# Prography Android
![image](https://github.com/user-attachments/assets/e7a002cd-5565-4d5c-8f39-2843715b97b4)


## 기술 스택
<p align="center">
  <img src="https://github.com/user-attachments/assets/be052746-ad45-412d-a57a-4c3fc8519f2b">
</p>

## 아키텍처
![image](https://github.com/user-attachments/assets/0c6183e1-95f9-4b3e-b281-c8951f3acaf3)

해당 프로젝트는 Clean Architecture를 기반으로 구축하였습니다
Clean Architecture는 도메인 중심 설계 아키텍처 기반으로 Presentation Layer와 Data Layer가 Domain을 의존하는 형태로 개발하였습니다

### UI Layer
![mad-arch-ui-udf](https://github.com/user-attachments/assets/aef7bd6e-45e8-4b52-ab41-2b4889ec3988)

프레젠테이션 계층은 안드로이드에서 권장하는 단방향 데이터 흐름(UDF)을 따르고 있습니다

**Event**
Button, CheckBox, Switch, Tabs 등의 UI 요소에서 이벤트가 발생하면 ViewModel을 호출합니다.

**UI State**
UI 상태에 따라 Loading, Error, Success 등으로 분기 처리하여, UI State(ViewModel)에 따라 사용자에게 표시합니다.

### Data Layer
![image](https://github.com/user-attachments/assets/109241f8-4bed-4ebc-abe6-8043beff2b7b)

데이터 계층은 Repository 패턴으로 설계되며, DB 쿼리 및 네트워크 작업을 처리합니다. 
또한, 오프라인 및 캐싱 작업도 이 계층에서 수행합니다.

### Domain Layer
![image](https://github.com/user-attachments/assets/0764c2da-0a44-4581-a7ec-e440d307edf8)

도메인 계층은 비지니스 로직이 존재하는 계층입니다
핵심 업무 규칙인 Entity가 존재하며, UseCase는 Entity의 데이터의 흐름을 조정하도록 설계하였습니다


## 모듈화
해당 프로젝트는 모듈화를 통해 빌드 시간을 낮추고, 모듈 간의 더욱 명확한 의존성 설계 및 캡슐화 하였습니다
![image](https://github.com/user-attachments/assets/99ea9249-5df0-4fd1-a8e9-130b0dfee584)

- App : 앱 모듈은 애플리케이션의 진입점으로, 앱 모듈은 feature 모듈에 종속되며 Navigation Host가 존재합니다.
- Feature : 화면 별로 독립적인 기능에 따라 존재합니다.
- Core : 앱 아키텍처의 특정 레이어를 나타내지는 않지만, 여러 모듈에서 공통적으로 필요로 하는 기능을 제공합니다.
