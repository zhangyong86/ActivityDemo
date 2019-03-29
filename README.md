# ActivityDemo
activity的生命周期和启动模式
屏幕旋转activity的生命周期变化

Activity的启动模式
  * standard
  * singleTop(栈顶复用)
  * singleTask(栈内复用)
  * singleInstance(独立的任务栈)

     

 异常Activity生命周期：
 (activity异常退出-非用户主动退出-内存不足等)
  * onPause->onSaveInstanceState->onStop->onDestroy->onCreate->onStart->onRestoreInstanceState->onResume
  
  问题：假设当前Activity A，用户开启Activity B，A的onPasue()和B的onResume()谁先执行。
  
  答案：ActivityStack源码中，resumeTopActivityInnerLocked方法描述
  (then continue to schedule the previous activity to be paused, while at the same time resuming the new resume activity)

