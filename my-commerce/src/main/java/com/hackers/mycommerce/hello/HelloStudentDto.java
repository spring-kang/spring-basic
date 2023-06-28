package com.hackers.mycommerce.hello;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class HelloStudentDto {
    String name;

    public static HelloStudentDto from(HelloStudent student) {
        return HelloStudentDto.builder()
                .name(student.getName())
                .build();
    }
}
