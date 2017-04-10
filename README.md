# 易读
模仿网易云音乐UI，用知乎和gankio 网易新闻 豆瓣电影的API来完成一个基于Material Design +Rxjava + Retrofit + dagger2 + MVP构架的项目<br>
<br>为了更好的学习Material Design和主流框架，于是有了该项目。
<br>[APP下载地址](https://fir.im/4hfb?release_id=58eae5f2ca87a867100000b2)或者[github中APP下载地址](https://github.com/laotan7237/EasyReader/blob/master/easyreader.apk)大家觉得项目构建慢的话，可以先下载来玩玩看，支持5.0以上，本项目可以支持4.0以上不过部分动画会失效，如果要用4.0-5.0的自己去gradle里面修改。
## Screenshots
![](https://github.com/laotan7237/EasyReader/blob/master/imagefile/home.png)
![](https://github.com/laotan7237/EasyReader/blob/master/imagefile/zhihudetail.png)
![](https://github.com/laotan7237/EasyReader/blob/master/imagefile/movietop.png)
![](https://github.com/laotan7237/EasyReader/blob/master/imagefile/movielatest.png)
![](https://github.com/laotan7237/EasyReader/blob/master/imagefile/moviedetail.png)<br>
## Preview
![](https://github.com/laotan7237/EasyReader/blob/master/imagefile/easyreader.gif)

## tips:
* 项目还在更新阶段，发现bug请您及时以我联系，有好的建议欢迎[issue](https://github.com/laotan7237/EasyReader/issues)、qq=502325525
* IDEIDE提示缺少Dagger开头的Class直接编译即可，会由Dagger2自动生成，如DaggerActivityComponent这个是红色的，可以直接按运行。
* 本项目的API数据内容所有权归原作公司所有。

## Features 特性
* 遵循Material Design设计风格。
* Rxjava+Retrofit2网络请求，并进行封装错误可以进行统一处理。
* Dagger2将M层注入P层，将P层注入V层，无需new，直接调用对象。
* 抽取BaseActivity和BaseFragment,非常值得学习，BaseActivity还添加了侧滑关闭哦，而且完全是作者自己想出来的。
* BaseRecyclerViewAdapterHelper+RecyclerView完成下拉刷新，上拉加载更多。
* Glide做图片的处理和加载
* 使用CoordinatorLayout + AppBarLayout + CollapsingToolbarLayout。
* 自定义控件[电影详情页自定义控件](http://blog.csdn.net/laotan7237/article/details/60576755)影人图片左右滑动的Viewgroup，侧滑关闭也是属于自定义控件的知识，都是作者自己想出来的，值得学习的。
## Thanks
### API:<br>
知乎日报  干货集中营API 豆瓣电影。<br>
### APP:<br>
[云阅](https://github.com/youlookwhat/CloudReader)项目部分UI从该项目中获取，非常感谢作者，作者对我也有很大的帮助<br>
[GeekNews](https://github.com/codeestX/GeekNews)学习了他的degger2的思路<br>
[looklook](https://github.com/xinghongfei/LookLook)参考了他的网易API。<br>
## End:<br>
如果该项目对您有帮助，帮忙点个star吧。<br>
作者还会努力更新，带来更多的技术点。
## About me:<br>
* QQ: 502325525
* 简书: http://www.jianshu.com/p/04f4d4d1c424
* CSDN: http://blog.csdn.net/laotan7237/article/details/68946797
