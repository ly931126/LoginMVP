MVP的使用
------
[MVP参考链接](http://www.2cto.com/kf/201603/496355.html)
[MVP知识要点@寻之川](http://note.youdao.com/share/?id=d1e77e62e083ed32482204f5c070084a&type=note#/)

效果图
---
![MVP实现的登录界面](https://github.com/ly931126/LoginMVP/blob/master/device-2017-08-13-140205.png)


---
### 一.整体架构
#### 1.model:数据源层，实现与网络或数据库的交互逻辑。
#### 2.view :即Activity ,popupwindow ,Fragment显示数据，
- 与Mvc框架中view的区别：
##### （1）在MVP框架中，view层需要定义接口，view实现接口
##### （2）在MVP框架中，view层不与Model层直接交互
#### 3.presenter:从Model层获取数据，把处理后的数据传递到view层，实现model层和view层的间接交互。
  - mvp框架就是把一些处理逻辑从view层抽取出来，放在model层，通过presenter层实现model层和view层的间接交互。
### 二.Mvp框架中文件命名
- 如：以LoginActivity为例：
```
view接口的名字为LoginView；

presenter接口的名字为 LoginPresenter;

实现类为 LoginPresenterImp;
```
### 三.MVP的基本实现方式
#### 1.写一个view接口，view类（即LoginActivity）实现它；
#### 2.写一个Presenter接口，presenterImp实现它;
#### 3.对model的处理逻辑放在presenterImp类对presenter接口的实现方法中，view类调用presenter接口中的抽象方法；
#### 4.presenterImp类调用view接口中的抽象方法，实现Presenter层的桥梁作用。

### 四.MVP框架的特点
#### 1.view和presenter一一对应；
#### 2.相较于mvc框架，mvp会增加许多接口和类，通过接口传递数据和对象，MVP框架更适应于大项目中。
#### 3.model与view不直接交互，presenter层是连接model层和view层的桥梁
- 接口的作用：通过接口传递数据和对象，接口具有目录索引的作用，具体逻辑在实现接口的类中，使得逻辑更清晰。

### 五.MVP对于listview ,popupwindow的处理
#### 1.对listview的处理
```
   相对于MVC框架，对adapter实例化时传递的参数不变（可以传递list对象)；
   对listview中项或某个控件的点击事件处理：如果该点击事件中涉及到实体类对象的逻辑处理，则把相应逻辑抽离出来
```
#### 2.对popupwindow的处理
  -实例化popupwindow时可以直接传递数据或对象，与在mvc的处理一样
#### 3.使用Intent跳转时可以直接传递数据或对象，与在mvc的处理一样
#### 4.可以用butterKnife绑定控件id ,但注解的点击事件处理不能用。