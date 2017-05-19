>- 编写把函数做为一等公民来传递就是函数式编程风格

>- StreamApi和集合api行为差不多，都能访问数据项目的序列，但是集合更加主要的用来存储访问数据，而stremapi是倾向于计算

>- 谓词：返回boolean的函数

### 复合lambda表达式
- 谓词复合
```
Predicate<Apple> predicate = (Apple::isRed);
        predicate=predicate.or(Apple::isBlue);

```

- 函数复合

可以对Function进行组合，提供了两个默认方法`andThen`、`compose`
```
Function f1=x->x+1;
Function f2=x->x*1;
Function result1=f1.andThen(f2);  ==> result1=f2(f1(x))
Function result2=f1.compose(f2);  ==> result1=f1(f2(x)) 这两个正好相反

```
