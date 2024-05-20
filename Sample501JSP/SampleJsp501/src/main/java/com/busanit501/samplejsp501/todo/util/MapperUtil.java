package com.busanit501.samplejsp501.todo.util;

import org.modelmapper.ModelMapper;

public enum MapperUtil {
  INSTANCE;

  // 멤버로, modelMapper 필요함. 주입, 포함, DI
  private ModelMapper modelMapper;

  // 양방향 변환에 필요한 초기 설정.

  // 기본 생성자에서, 설정되게 하기.
  MapperUtil(){
    // 위에서 주입했던 인스턴스를 선언만 해서, 여기서 할당을 함.
    // 0x100 이 할당이 됨.
    this.modelMapper = new ModelMapper();
    // 추가 설정은,

  }
}
