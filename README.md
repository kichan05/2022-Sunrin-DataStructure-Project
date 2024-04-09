# 개요
> 이 프로젝트는 2022 선린 자료구조 교과시간에 진행한 프로젝트입니다.

자세한 내용은 [발표자료](https://drive.google.com/file/d/1OiGBiA-CBR-pkCk_im2QG75xILhTpE_p/view?usp=sharing)를 함고해주세요

# 기술 스택
- Java

# 시연
- Plaver vs Plaver
  
  https://github.com/kichan05/2022-Sunrin-DataStructure-Project/assets/70091408/f2366c76-b650-4707-89a9-5daca8a011f0
  
- Ai vs Ai
  
  https://github.com/kichan05/2022-Sunrin-DataStructure-Project/assets/70091408/62c65c21-f799-48c9-b571-7e726264cc28

# 객체 지향 설계

![전체적인 객체지향 설계](https://github.com/kichan05/2022-Sunrin-DataStructure-Project/assets/70091408/81401c1c-9505-4cab-b9f3-848e6b26cb2b)

## 기물 클래스 

![기물 클래스 구조](https://github.com/kichan05/2022-Sunrin-DataStructure-Project/assets/70091408/41044925-220a-4b85-94c8-804499837f96)

- 모든 기물을 클래스로 구현
- 모든 기물 클래스는 Piece 추상 클래스를 상속
- Piece 클래스에서 팀, 좌표, 형태 등 변수 설정
- 자식(각각의 기물)클래스에서 움직이는 방식의 함수를 각각 정의

## 게임 상태 클래스

![게임 상태 클래스 구조](https://github.com/kichan05/2022-Sunrin-DataStructure-Project/assets/70091408/bc671635-efb3-4596-a2e3-4950bc232020)

- 싱글톤 객체로 구현
- 플레이어 객체, 게임 상태, 각팀의 체크 상태, 각팀의 체크 메이트 상태
등을 저장한다.

## 보드 클래스
![보드 클래스 구조](https://github.com/kichan05/2022-Sunrin-DataStructure-Project/assets/70091408/6fac567b-bc2e-455d-84ea-a5933f427ce8)

- 게임 보드의 정보를 저장하는 클래스
- 기물 목록, 선택된 기물의 이동 가능 위치 등을 저장

## 플레이어 클래스

![플레이어 클래스 구조](https://github.com/kichan05/2022-Sunrin-DataStructure-Project/assets/70091408/9340f142-b71c-4431-8b6c-9ef26439e1db)

- 인간과 인공지능을 각각 Human, AlphaChess 클래수로 구현
- 두 클래스 모두 Player 추상 클래스를 상속
- Player 클래스에서 selectPiece(), selectMovePos() 메소드 선언
- Human 클래스는 사용자의 입력으로, AlphaChess 클래스는 랜덤 선택으로 메소드 정의
