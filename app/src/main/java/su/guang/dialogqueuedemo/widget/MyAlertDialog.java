package su.guang.dialogqueuedemo.widget;

import android.content.Context;
import android.content.DialogInterface;

import com.alertdialogpro.AlertDialogPro;

import su.guang.dialogqueuedemo.common.DialogManager;

/**
 * Created by Jaren on 2017/2/7.
 */

public class MyAlertDialog {

    private AlertDialogPro dialogPro;

    /**
     * Dialog优先级
     */
    private int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public AlertDialogPro getDialogPro() {
        return dialogPro;
    }

    public void setDialogPro(AlertDialogPro dialogPro) {
        this.dialogPro = dialogPro;
    }

    /**
     * 显示Dialog
     *
     * @see MyAlertDialog#show(MyAlertDialog dialog)
     */
    public void show() {
        show(this);
    }

    /**
     * 按照队列中的顺序出队显示
     * @param dialog 待显示的对话框
     *               如果为null，表示继续显示Queue中其他的dialog
     */
    private void show(MyAlertDialog dialog){
            if(dialog != null){
                DialogManager.getDialogQueue().offer(dialog);
            }

            if(DialogManager.current == null){
                DialogManager.current = DialogManager.getDialogQueue().poll();

                if(DialogManager.current != null){
                    DialogManager.current.getDialogPro().show();
                    DialogManager.current.getDialogPro().setOnDismissListener(new AlertDialogPro.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            DialogManager.current = null;
                            // dialog关闭后，继续show(null)
                            show(null);
                        }
                    });
                }
            }
    }


    public static class Builder {

        AlertDialogPro.Builder mBuilder;

        public Builder(Context context, int theme) {
            mBuilder = new AlertDialogPro.Builder(context,theme);
        }

        public Builder setMessage(CharSequence message) {
            mBuilder.setMessage(message);
            return this;
        }

        public MyAlertDialog create() {
            MyAlertDialog myAlertDialogPro = new MyAlertDialog();

            AlertDialogPro dialog = mBuilder.create();

            myAlertDialogPro.setDialogPro(dialog);

            return myAlertDialogPro;
        }
    }
}
