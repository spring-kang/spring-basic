package com.hackers.mycommerce.hello;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class StudentDto {
    String name;

    public static StudentDto from(Student student) {
        return StudentDto.builder()
                .name(student.getName())
                .build();
    }
}
