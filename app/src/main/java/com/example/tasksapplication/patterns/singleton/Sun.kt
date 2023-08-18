package com.example.tasksapplication.patterns.singleton

class Sun private constructor() {

    companion object {
        @Volatile
        private var sun: Sun? = null

        fun getInstance(): Sun {
            if (sun == null) {
                synchronized(this) {
                    if (sun == null) {
                        sun = Sun()
                    }
                }
            }

            return sun!!
        }
    }

}


