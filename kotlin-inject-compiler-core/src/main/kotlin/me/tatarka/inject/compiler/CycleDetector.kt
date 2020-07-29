package me.tatarka.inject.compiler

class CycleDetector {

    private val types = mutableListOf<TypeKey>()

    fun check(typeKey: TypeKey): CycleResult {
        return if (typeKey in types) {
            //TODO: check resolvable
            CycleResult.Cycle
        } else {
            types.add(typeKey)
            CycleResult.None
        }
    }

    fun pop() {
        types.removeAt(types.lastIndex)
    }
}

enum class CycleResult {
    None, Resolvable, Cycle
}
