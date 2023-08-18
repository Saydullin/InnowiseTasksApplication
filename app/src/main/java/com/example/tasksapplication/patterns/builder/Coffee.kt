package com.example.tasksapplication.patterns.builder

class Coffee(
    private val isDouble: Boolean,
    private val isMilk: Boolean,
    private val isCream: Boolean,
    private val isSugar: Boolean,
    private val isCinnamon: Boolean,
    private val isSyrup: Boolean,
) {

    class Builder: CoffeeBuilder<Builder, Coffee> {
        private var isDouble = false
        private var isMilk = false
        private var isCream = false
        private var isSugar = false
        private var isCinnamon = false
        private var isSyrup = false

        override fun double(isDouble: Boolean): Builder {
            this.isDouble = isDouble
            return this
        }

        override fun milk(isMilk: Boolean): Builder {
            this.isMilk = isMilk
            return this
        }

        override fun cream(isCream: Boolean): Builder {
            this.isCream = isCream
            return this
        }

        override fun sugar(isSugar: Boolean): Builder {
            this.isSugar = isSugar
            return this
        }

        override fun cinnamon(isCinnamon: Boolean): Builder {
            this.isCinnamon = isCinnamon
            return this
        }

        override fun syrup(isSyrup: Boolean): Builder {
            this.isSyrup = isSyrup
            return this
        }

        override fun build(): Coffee {
            return Coffee(
                isDouble = isDouble,
                isMilk = isMilk,
                isCream = isCream,
                isSugar = isSugar,
                isCinnamon = isCinnamon,
                isSyrup = isSyrup,
            )
        }

    }

}


