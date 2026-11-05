# 反复犯的错

写完代码、跑之前对着这个清单检查一遍。

## 1. 忘记保存 ⭐⭐⭐（最常见）
- 症状：`Could not find or load main class MainKt`、`ClassNotFoundException: MainKt`、改了没效果、我看文件是空的
- 解决：`Cmd + S`；最好开 **File → Auto Save**

## 2. 大写类型名 vs 小写的具体值 ⭐⭐⭐
- 类型（图纸）没有具体的值，只有某一个对象才有
- ❌ `Rank.symbol`、`Triangle.sideA`、`ToDoItem.count {...}`
- ✅ `rank.symbol`、`sideA`、`items.count {...}`
- 在 class 里面访问自己的属性：**直接写名字**，前面什么都不加

## 3. 代码放错地方 ⭐⭐
- 属性要写在 **class 的大括号里**，不是 main 里（`isMarried`、`age`）
- 执行语句（`println`、`require`）不能直接放在 class 或文件最外层：要放进 `fun main()` 或 `init { }`
- 改代码前看一眼标签页路径：是不是在**对的 task 文件夹**、**对的函数**里（写进过 12.5.1、写进过 `add()`）
- 造对象写在 main 里，不要写在自己的 class 里面（会无限套娃）
- VS Code 新建时分清 **New File** 和 **New Folder**（建成了同名文件，文件夹就建不了）

## 4. 属性 vs 方法：括号 ⭐⭐
- computed property：`val area get() = ...`，用的时候**没括号** `t.area`
- 方法：`fun area() = ...`，用的时候**有括号** `t.area()`
- ❌ `fun perimeter { val p = ... }`：既不是属性，也没 return，算完就丢

## 5. 字符串转别的类型 ⭐⭐
- ❌ `birth.LocalDate()`、`parts[0].LocalDate()`
- ✅ `LocalDate.parse(字符串)`、`ItemStatus.valueOf(字符串)`、`"42".toInt()`
- 格式：**类型.parse(字符串)**

## 6. 拼写 / 大小写 ⭐⭐
- `symbol` 不是 `symble`
- `toString` 不是 `tostring`（名字差一个字母就 override 不了）
- 枚举选项大小写跟定义一致：`ItemStatus.Done` 不是 `done`
- 类型名大写开头：`Int`、`Double`、`String`
- `class` 关键字小写
- `package` 不是 `packge`；包名里不能有空格（`myapp` 不是 `my app`）

## 7. 符号
- 一个 `=` 是赋值，两个 `==` 才是比较
- `<=` 不是 `=<`
- `&&` 是逻辑"并且"，**不是**拼字符串；拼字符串用 `"${a}${b}"`
- 中文标点（（ ）？“ ”）→ 英文
- 复制时末尾多出 `]\`、`v` 之类的乱码，检查一下

## 8. 引号位置
- 引号只包住**文字**：`Person.create("XXX", LocalDate(1990, 12, 24))`
- ❌ `"XXX,LocalDate(...)"`：整段变成一个字符串
- ❌ `1997-12-24` 不加引号：是减法 = 1961
- `1997/12/24` 是除法，不是日期

## 9. 字符串模板
- 简单变量：`"$x"`
- 带点号的：`"${a.x}"`、`"${Day.entries}"`，必须加大括号

## 10. 在 main 里调用方法要说清楚是谁的
- ❌ `applyInterest()`、`withdraw(50)`、`distanceTo(...)`
- ✅ `p.applyInterest()`、`p.withdraw(50)`、`a.distanceTo(b)`
- 只有在 **class 里面**才能省略，默认是"自己的"
- 只读出来不打印看不到：`p.balance` → `println(p.balance)`

## 10b. 第一次出现的变量要 `val`
- ❌ `date = readln()`、`currentCard = Card(r, s)`
- ✅ `val date = readln()`

## 11. Python 习惯带过来
- 元组 `(r, s)` → Kotlin 要写 `Card(r, s)`
- `a if cond else b` → Kotlin 是 `if (cond) a else b`
- Kotlin **不会**自动把 Int 转成 Double：`x.toDouble()`
- for 循环：`for (x in list) { }`，括号 + 大括号

## 12. 构造函数
- 构造函数参数**有 `val/var` 才是属性**，没有就只是参数
- 同一个属性不能定义两次（构造函数里一次、大括号里又一次 → Conflicting declarations）
- 次构造函数参数前**不能**写 `val/var`

## 12b. 继承 / 抽象类
- **抽象类不能直接造**：❌ `Vehicle(50)` ✅ `Car(50)`；但标签可以用抽象类 `val car: Vehicle = Car(50)`
- 实现父类的 abstract 方法要写 `override`，**不用**再写 open（abstract 已经比 open 更强）
- 子类构造函数里，父类已有的属性**不加 val**，只转交：`(holder: String, val rate: Double) : BankAccount(holder)`

## 13. 逻辑
- `init` 后面**不带括号和条件**：`init { require(合法条件) { "信息" } }`；require 里写的是**合法**的条件
- `require` 是拦**非法输入**、抛异常；要返回 true/false 的（比如 `contains`）直接返回比较结果，不用 require
- `>` 和 `>=` 的区别全在边界值上（半径 0、名字长度 0）
- getter 里不能读自己（`name` 的 get 里写 `name` → 无限循环），用 `field`
- 返回 Boolean 不用 `if (...) return true else return false`，直接 `return 条件`

---

# 还没吃透的概念（学到后面再回来看）

## 为什么父类里要写一个空的 `draw()`？（15.4，2026-11-05 标记）
- 我的疑问：反正每个形状都要写自己的 draw，为什么 Shape 里还要放一个空的？每个形状自己写一个 draw，再用 if 判断"能不能画"不行吗？
- 目前的解释：
  - Picture 的列表是 `MutableList<Shape>`，拿出来的元素 Kotlin 只知道"它是个 Shape"
  - Kotlin **编译时只看类型标签**：Shape 上没写 draw → 不让调用 `it.draw()`
  - Kotlin 没法问"你有没有 draw 方法"，只能问"你是不是 Circle"→ 又变成一个个列举类型（Version 1）
  - Shape 里的 draw = 一个**承诺**："所有 Shape 都能画"。有了它，Picture 直接 `it.draw()`，加新形状不用改 Picture
  - Python 可以直接调用（duck typing），写错了运行时才报错；Kotlin 要求提前规定好，编译时就检查
- 预计 Section 16 抽象类、week 5 做完会更清楚
