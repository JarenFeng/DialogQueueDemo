##DialogQueue

### Dialog管理队列
DialogQueue需要配合MyAlertDialog使用。
DialogQueue可以按照优先级显示Dialog。当优先级相同时，从队尾出队显示。
如：


``` Java
dialog1.setPriority(1);
dialog1.show();
dialog2.setPriority(2);
dialog2.show();
dialog3.setPriority(3);
dialog3.show();
dialog4.setPriority(2);
dialog4.show();
```



   显示顺序为dialog1→dialog3→dialog4→dialog2。

![demo](https://github.com/Guangsu/DialogQueueDemo/blob/master/demo.gif)

   感谢
   [AlertDialogPro](https://github.com/fengdai/AlertDialogPro)
