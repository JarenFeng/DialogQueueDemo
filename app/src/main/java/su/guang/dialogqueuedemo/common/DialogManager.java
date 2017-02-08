package su.guang.dialogqueuedemo.common;

import android.content.Context;

import su.guang.dialogqueuedemo.R;
import su.guang.dialogqueuedemo.widget.MyAlertDialog;

/**
 * 全局Dialog管理
 * Created by Jaren on 2017/2/7.
 */

public class DialogManager {

    /**
     * 全局Dialog队列
     */
    private static DialogQueue dialogQueue;

    /**
     * 当前显示的Dialog
     */
    public static MyAlertDialog current;

    /**
     * 获取全局Dialog队列
     * @return
     */
    public static DialogQueue getDialogQueue() {
        if(dialogQueue == null)
            dialogQueue = new DialogQueue();
        return dialogQueue;
    }

    /**
     * 显示一个Dialog
     * <p>如果当前Dialog({@link DialogManager#current})不为空，则该Dialog按优先级入队；否则直接显示。</p>
     * @param context
     * @param content 内容
     * @return 返回将要显示的Dialog实例
     */
    public static MyAlertDialog showDialog(Context context,String content){
        MyAlertDialog.Builder builder = new MyAlertDialog.Builder(context, R.style.Theme_AlertDialogPro_Material);
        builder.setMessage(content);
        return builder.create();
    }
}
