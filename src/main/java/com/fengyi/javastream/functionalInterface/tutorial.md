# Java functional interface
It's a interface has exactly one abstract method

## Basic functional interface
- Function
  - receive T, return R
- Predicate
  - receive T, return boolean(true/false)
- consumer
  - receive T, return void
- supplier
  - receive void, return R
  
## Functional interface with primitive type

- DoubleFunction
- LongFunction
- IntFunction
- IntToDoubleFunction
- IntToLongFunction
- BooleanSupplier
- intConsumer
- intPredicate
...

## Composite functional interface
- BiConsumer
- BiFunction
- UnaryOperator
- BinaryOperator
- IntBinaryOperator
