package com.yongjincompany.todo.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    var title: String = "",
    var completed: Boolean = false
) {
    constructor() : this(0L, "", false)
}

//JPA가 findById(id)를 호출할 때 내부적으로 리플렉션을 통해 해당 entity를 인스턴스화하고 DB에서 조회한 값들을 하나씩 객체에 채워나가기 때문에
//data class에 JPA가 객체를 만들기 위한 임시 값을 넣기 위한 기본 생성자를 만들어야함.
//허나 기본 생성자가 없어도 기본값만 채워넣어도 동작하는데

//그렇게 할 시에는 Kotlin은 모든 파라미터에 기본값을 가진 주 생성자 하나만 생성한다.
//그리고 Hibernate 5.3 이후 버전부터는 Kotlin의 기본값 기반 생성자를 어느 정도 지원하기 때문에
//즉, 리플렉션으로 Todo() 호출 시, JVM에는 파라미터 있는 생성자밖에 없지만, Hibernate가 Kotlin metadata를 보고 호출해주는 방식으로 동작하기 때문에 이가 가능함.