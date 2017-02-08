package su.guang.dialogqueuedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import su.guang.dialogqueuedemo.common.DialogManager;
import su.guang.dialogqueuedemo.common.DialogQueue;
import su.guang.dialogqueuedemo.widget.MyAlertDialog;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_show) {
                    MyAlertDialog dialog1 = DialogManager.showDialog(MainActivity.this, "第1个\n" +
                            "PRIORITY=MIN");
                    dialog1.setPriority(DialogQueue.DIALOG_PRIORITY_MIN);
                    dialog1.show();

                    MyAlertDialog dialog2 = DialogManager.showDialog(MainActivity.this, "第2个\n" +
                            "PRIORITY=MEDIUM");
                    dialog2.setPriority(DialogQueue.DIALOG_PRIORITY_MEDIUM);
                    dialog2.show();

                    MyAlertDialog dialog3 = DialogManager.showDialog(MainActivity.this, "第3个\n" +
                            "PRIORITY=MAX");
                    dialog3.setPriority(DialogQueue.DIALOG_PRIORITY_MAX);
                    dialog3.show();

                    MyAlertDialog dialog4 = DialogManager.showDialog(MainActivity.this, "第4个\n" +
                            "PRIORITY=MEDIUM");
                    dialog4.setPriority(DialogQueue.DIALOG_PRIORITY_MEDIUM);
                    dialog4.show();
                }
            }
        });
    }
}
