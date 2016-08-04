references: 
http://blog.csdn.net/wwj_748/article/details/42523611

http://blog.csdn.net/superjunjin/article/details/45022595

1. 自定义动画
/PullToRefresh/res/drawable/home_refresh_anim.xml

2. 修改下拉刷新布局：
/PullToRefresh/res/layout/pull_to_refresh_header_my.xml

3. 增加自定义的加载布局
/PullToRefresh/src/com/handmark/pulltorefresh/library/internal/TweenAnimLoadingLayout.Java	

4. 我们只要修改开源项目中的LodingLayout代码：
/PullToRefresh/src/com/handmark/pulltorefresh/library/internal/LoadingLayout.java
注释掉不需要的部分(ProgressBar和SubHeaderText)

5. 替换之前的刷新layout为TweenAnimLoadingLayout
找到PullToRefreshListView，发现头脚的layout用的都是LoadingLayout，找到头脚layout的创建方法createLoadingLayout进入，在createLoadingLayout方法中再进入createLoadingLayout，找到最原始的新建动画layout的地方，把默认的RotateLoadingLayout改成TweenAnimLoadingLayout就行了

在PullToRefreshBase类下，修改

//在最原始的地方把新建动画layout换成TweenAnimLoadingLayout  
```java
    LoadingLayout createLoadingLayout(Context context, Mode mode, Orientation scrollDirection, TypedArray attrs) {  
        switch (this) {  
            case ROTATE:  
            default:  
//              return new RotateLoadingLayout(context, mode, scrollDirection, attrs);  
                return new TweenAnimLoadingLayout(context, mode, scrollDirection, attrs);  
            case FLIP:  
                return new FlipLoadingLayout(context, mode, scrollDirection, attrs);  
            }  
        }  
```
