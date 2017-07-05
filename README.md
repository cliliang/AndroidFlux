# AndroidFlux
基于AndroidFlux框架的完整项目工程，将在项目中用到的Flux框架做个总结。

### 网络
retrofit2.0

### 模块
功能模块化，界面跳转的解耦。但因为在MainRouter中传的Context会被长期持有，存在内存泄漏的问题，但这个Context因为用到单例，又只会被
持有一个。

跨模块跳转：
```
MainRouter.getInstance(getActivity()).showActivity(ModuleID.USER_MODULE_ID, UserUI.LoginActivity);
```
模块内跳转：
```
UserRouter.getInstance(LoginActivity.this).showActivity(UserUI.RegisterActivity);
```

### 多渠道打包
打包单个渠道包，Terminal命令：
```
./gradlew :app:assembleBaiduRelease
```

打包全部渠道包，Terminal命令：
```
./gradlew :app:assembleRelease
```

### 状态栏
首页状态栏透明，功能界面状态栏颜色与主色调相一致

### Toolbar
自定义的Toolbar

### 首页
首页底部有四个导航按钮