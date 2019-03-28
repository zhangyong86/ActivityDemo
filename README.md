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

