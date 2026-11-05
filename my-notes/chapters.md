# 每章重点

## Section 8：Lambda
- `{ it > 5 }`：`it` 代表每一个元素
- `count { }` 数有几个、`filter { }` 挑出来组成新列表、`map { }` 每个转换一下
- `minBy` / `maxBy` / `average` / `first` / `last`
- sequence：懒计算，最后要 `toList()`
- scope 函数：let / also / run / with / apply

## Section 9：异常
- `require(条件) { "信息" }` → 不满足抛 IllegalArgumentException（**参数**不对）
- `check` / `error` → IllegalStateException（**状态**不对）
- `try { } catch (e: 具体异常) { }`：先写具体的，再写宽泛的
- `finally` 不管怎样都执行

## Section 10：Null 安全
- `String?` 可以是 null
- `?.` 安全调用、`?:` null 时用后面的值
- `toIntOrNull()`、`readlnOrNull()` 这些 `...OrNull`

## Section 11：OO 建模
- 找名词 → 类；CRC 卡片；高内聚低耦合
- UML 类图：draw.io / Mermaid

## Section 12：Class ⭐
- **class 是图纸，`Point()` 造出来的是对象**，每次 `Point()` 都是一个全新的、独立的
- 属性 property：`val` 只读 / `var` 可改
- 主构造函数：`class Point(val x: Double, val y: Double)`，有 val/var 的参数直接变成属性
- 次构造函数：`constructor() : this(0.0, 0.0)`，**必须转交给主构造函数**
- `init { require(...) }`：每次造对象都会跑，放检查
- 方法：写在 class 里的函数，直接用 `x`（= `this.x`，自己的）
- `override fun toString() = "..."`：决定 `println(对象)` 显示成什么
- 属性背后是 getter / setter：
  - `get() { return field.uppercase() }`：读的时候加工，`field` = 存着的值
  - `set(value) { require(...); field = value }`：写的时候检查，`value` = 等号右边的新值
  - 造对象（初始化）**不走** setter
- computed property：`val age get() = ...`，不存值，每次现算，用的时候没括号
- 参数 vs 属性：参数是临时的，属性存在对象里
- `private`：只有 class 内部能用；所有修改都必须走你设计的方法 → 封装
- data class：自动生成 `toString` / `equals` / `hashCode`，**只看主构造函数里的属性**
- enum：固定几个选项；`.name`、`.entries`、`valueOf("...")`（大小写不对会抛异常）；可以带属性 `Clubs('♣')`，最后一个选项后面用 `;`
- `object`：只有一个的对象；`companion object`：属于整个类、所有对象共用；静态工厂方法 = `private constructor` + companion 里的 `create()`

## Section 14：Package
- package = 给类起"姓氏 / 地址"，防重名：`myapp.orders.Customer` 和 `bank.Customer` 是两个不同的类
- 文件第一行声明：`package myapp.orders`（点号 = 层级）
- 同一个包里直接用；不同包：写全名 `myapp.orders.Customer(...)` 或 `import myapp.orders.Customer`（import 要写到**类名**，或 `.*` 导入整个包）
- 习惯：文件夹路径和包名对应，`myapp.orders` → `src/myapp/orders/`（Java 强制，Kotlin 不强制但都这么做）
- week 5：`StudentAccount.kt` 第一行要写 `package comp2850.banking`

## Section 15：继承
### 15.2 子类
- `open class Parent` + `class Child : Parent()`：冒号读作"继承自"，左边孩子、右边父母
- Kotlin 的 class **默认不能被继承**，要被继承必须写 `open`；**open 不会遗传**，每一层要被继承都要自己写
- 子类自动拥有父类的**所有**属性和方法（不是复制，是直接就有），孙子也拥有爷爷的
- 构造函数：`class Student(name: String, val degree: String) : Person(name)`
  - 父类已有的属性：不加 val，只是参数，转交给父类构造函数
  - 子类自己新加的：加 val
- 造子类对象：**父类构造函数先跑，子类后跑**（先打地基再盖楼）；直接造子类就行，父类部分自动造好
- `protected`：自己和子类能用；`private`：子类也不能用
- `private set`：外面能读不能改，子类也不能改 → 子类要改余额只能调用父类的 `deposit()`

### 15.3 重写 override
- 方法也默认不能改写：父类 `open fun`，子类 `override fun`
- 规则只有一套：类要被继承 → `open class`；方法要被改写 → `open fun`；子类改写 → `override fun`
- `toString` 不是例外：每个类都自动继承 `Any`，`Any` 里已经 `open fun toString()`，所以只要写 override
- 子类 override 不影响父类：`Person().speak()` 还是原版
- `val p2: Person = Student("Maths")`：冒号是声明类型（标签），等号是装的值。学生也是人，所以 Person 类型能装 Student
- **动态绑定**：调用方法时看**实际装的是谁**，不看标签 → `p2.speak()` 用的是 Student 版

### 15.4 案例：画图程序（多态）
- V1：Shape 没有 draw，Picture 要 `when { shape is Circle -> ...; shape is Rectangle -> ... }`，每加一种形状就要改 Picture ❌
- V2：Shape 里放一个空的 `open fun draw()`，子类各自 override；Picture 只要 `shapes.forEach { it.draw(context) }` ✅
- 加 Triangle 时 Picture 一个字都不用改 → **多态 polymorphism**：同一句 `it.draw()`，不同对象做不同的事

## Section 16：抽象类
- `abstract class` = 一个**类别**，不是具体的东西（"形状""交通工具""账户"）；**不能直接造对象**，不用写 open（天生就是被继承的）
- `abstract fun draw(...)`：只有名字，**没有大括号**；子类**必须** override，不写编译报错（要么子类自己也 abstract）
- 抽象类可以同时有写好的方法（`refuel`、`deposit`）和抽象方法（`drive`、`withdraw`）
- 父类那一行不是替子类做事，而是**统一名字 + 强制必须有** → 才能对一整个 `List<Shape>` / `List<BankAccount>` 统一调用

### ⭐ 看到一个 fun 就问两句（我自己总结的）
1. 所有子类都应该一模一样吗？是 → 普通 `fun`（子类不能改）
2. 不同子类可能有不同做法吗？
   - 有默认做法 → `open fun`（子类**可以**改，不改用默认）
   - 没有共同做法 → `abstract fun`（子类**必须**写）
- 例子：`deposit()` 普通；`toString()` open；`withdraw()` abstract
