<img src="https://ifh.cc/g/GduuK1.jpg" height ="300px" width="300px"></img>



# 📢프로젝트 소개



사용자의 위치 또는 지하철역 기반 놀 거리 / 먹거리 추천 서비스 앱 프로젝트입니다. 지하철 주변에서 뭐하고 놀지 알려주는 프로젝트로써  **놀면 뭐하니**로 프로젝트 이름을 정하였습니다.

<img src ="https://img.shields.io/badge/platform-Web-red"></img>
<img src ="https://img.shields.io/badge/tool-Androidstudio-green"></img>
<img src ="https://img.shields.io/badge/framework-Spring-skyblue"></img>
<img src ="https://img.shields.io/badge/database-MySQL-silver"></img> 
<img src ="https://img.shields.io/badge/server-AWS-gold"></img>
<img src ="https://img.shields.io/badge/language-Java%2C%20JavaScript-purple"></img>



# 😁 팀원 소개



<img src="https://ifh.cc/g/xxyJWv.jpg" width="80px"></img>
팀장 : **임건호** 

<img src="https://ifh.cc/g/BCtt1j.jpg" width="80px"></img>
Frontend 장 : 우주호

<img src="https://ifh.cc/g/WW8w5c.jpg" width="80px"></img>
Frontend Ace : 백상혁

<img src="https://ifh.cc/g/z4MKxX.jpg" width="80px"></img>
Backend 장: 김정현

<img src="https://ifh.cc/g/2U2ycR.jpg" width="80px"></img>
Backend : 김재현



# ⌛ 프로젝트 개발 일정



<img src="https://ifh.cc/g/cLKwxM.png" height = "350px" width="800px"></img>



# 🤝 Branch Rule



* Git Branch 전략
   * master -> develop -> feature/(기능 이름)
     
     * 기능 단위로 feature 생성 후 작업 -> develop으로 병합
     * 완성된 기능에 대한 feature 브랜치는 작업 완료 후 삭제 
   
   * Commit Rule : [브랜치명]커밋 내용 | JIRA이슈 ID
      ex)[develop] : [브랜치명] 커밋 내용 | JIRA이슈 ID
* JIRA번호 마지막에
     * 마침표 X
     * 영어만 사용
     * 브랜치명: 모두 소문자
     * 커밋내용 : 첫 글자만 대문자, 명령문 형식으로 작성
     
     

# ✍ Ground Rule



* 1일 1 commit

* 1주 1 merge request

* merge 후 브랜치 지우기



# 🛠 프로젝트 개발 환경 설정



## Frontend 개발환경



##### NPM 사용을 위한 Node.js 설치

>Node.js 는 오픈소스 자바스크립트 런타임 엔진(컴파일러 + 인터프리터 등)

>브라우저가 아닌 환경에서도 자바스크립트를 사용할 수 있게 해준다.

- [node.js 설치하기](https://nodejs.org/en/_) (LTS 버전 권장)

- 명령 프롬프트 창에서 `node -v`, `npm -v` 입력하여 설치 확인


##### Yarn 설치

>빌드 속도가 보다 빠르고 최근 활용도가 높다.

- [yarn 설치하기](https://yarnpkg.com/en/docs/install#windows-stable)

- 명령 프롬프트 창에서 `yarn -v`입력하여 설치 확인


##### Vue.js, Vue-cli 설치

> Vue  프로젝트의 Vue-cli 를 이용할 경우 Webpack, Eslint, 개발 서버 등의 설정이 자동으로 구성되어 손쉽게 프로젝트를 시작할 수 있는 장점이 있다.

- 명령 프롬프트 창에서 `yarn global add @vue/cli` 입력

- `vue --version` 입력하여 설치 확인


(참고) `vue create example` 를 입력하여 새로운 프로젝트를 생성할 수 있다.


##### Sass 설정

> Webpack에서 Sass 를 Css로 컴파일하기 위해 node-sass 와 sass-loader 를 설치한다.

- `yarn add node-sass sass-loader`


##### Vue-route, Vuex 설치

- `yarn add vue-router vuex`



## Backend 개발환경



##### Spring Boot 설치

> 간단한 구성을 위해 Spriong Boot 를 이용한다.

- Spring 사용을 위한 JDK 설치

  OpenJDK 공식 웹사이트에서 압축 파일을 다운로드 받고 압축 해제 후 해당 경로를 기억한다.

- 환경 변수 설정

  [내 컴퓨터 - 속성] -> [고급 시스템 설정] -> [환경 변수] -> [새로 만들기]

  - 변수 이름:  `JAVA_HOME`
  - 변수 값: `{해당 경로}`

  Path 편집 -> 변수 값에 `%JAVA_HOME%\bin` 추가

- 명령 프롬프트 -> `java -version` 설치 확인

- [Maven 설치](http://maven.apache.org/download.cgi)

- 환경 변수 설정

  - 변수 이름: `MAVEN_HOME`
  - 변수 값: `{해당 경로}`

  Path 편집 -> 변수 값에 `%MAVEN_HOME%\bin` 추가

- 명령 프롬프트 -> `mvn -v` 설치 확인

- VScode 설치
  - Spring Boot Extension Pack 설치
  - ctrl + shift + P -> Spring Initializer:Generate Maven Project 실행
    - Project Language: Java
    - Spring Boot Version: 2.2.2
    - Dependency: Lombok, Spring Web 선택


## 개발 환경 및 IDE


<img src="https://t1.daumcdn.net/cfile/tistory/213F23475902E2B619" width="80px"></img>
STS를 사용해 BackEnd 작업

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Visual_Studio_Code_1.18_icon.svg/1028px-Visual_Studio_Code_1.18_icon.svg.png" width="80px"></img>
VS CODE 사용하여 FrontEnd 작업

<img src="https://a0.awsstatic.com/libra-css/images/logos/aws_logo_smile_1200x630.png" height = "80px" width="80px"></img>
AWS 활용한 서버 연동

<img src="https://ifh.cc/g/H1VIIA.png"  height="100px" width="100px"></img>
Android Studio활용한 어플리케이션 개발



## FrontEnd 명령어 정리



* 명령어는 Node.js와 Vue.js가 설치되어 있다고 가정합니다

| 명령어                 | 내용                               |
| ---------------------- | ---------------------------------- |
| yarn install           | Node Modules에 있는 내용들 install |
| yarn serve --port 3000 | port번호 3000에서 로컬 서버 실행   |



## AWS 서버 명령어 정리 



| 명령어                                      | 내용                                    |
| ------------------------------------------- | --------------------------------------- |
| ssh -i K3A304T.pem ubuntu@K3A304.p.ssafy.io | 키 K3A304T.pem을 가지고 AWS 서버에 접속 |
| sudo java -jar test/THISIS-0.0.3.jar        | AWS 서버 내부에서 스프링 서버 실행      |
| (backend 폴더에서) mvn package              | 백엔드 스프링 서버 빌드                 |
| pm2 restart War2                            | 서버에 백엔드 빌드 파일 반영            |
| (frontend 폴더에서) npm run buile           | 프론트엔드 뷰 배포                      |

# :rocket: 프로젝트 배경

## Rest API





## Browser Support



| <img src="https://is2-ssl.mzstatic.com/image/thumb/Purple114/v4/bb/72/49/bb72493a-6ede-8369-5513-f1e9f930b642/AppIcon-0-1x_U007emarketing-0-6-0-0-85-220.png/246x0w.png" width="80px"> | <img src = "https://zdnet4.cbsistatic.com/hub/i/2019/01/29/f4eba7da-10cd-4b45-b974-464c08e145be/microsoft-edge.png" width="80px"></img> | <img src = "https://t1.daumcdn.net/cfile/tistory/253EC1495495846E1C" width = "80px"></img> |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| latest✔                                                      | latest✔                                                      | latest✔                                                      |


# 💪기여 방법



## 고려 사항

* 프로젝트를 변경하려는 사람들은 시작하는 방법에 대한 문서를 작성하는 것이 좋습니다. 
* 실행해야하는 스크립트 나 설정해야 할 환경 변수가 있을 수 있습니다. 
* 이 단계를 명시적으로 작성하십시오.
* AWS 서버의 작동 유무를 확인하십시오.



## Git Rules 
* git pull origin develop를 통해 develop와 먼저 merge 한 상태로 진행합니다.
* git status를 통해 변경 된 점을 확인합니다
* git add 를 통해서 변경을 주고 싶은 점을 진행합니다.
* git commit -m "지라번호" 를 통해서 각 지라에 등록을 해서 커밋합니다.
* git push origin feature/"개발 기능"를 통해서 기능기리 겹치지 않게 수행합니다.
* git bash에서 merge request를 신청합니다. 



# 📜License



본 가이드는 [MIT](https://choosealicense.com/licenses/mit/) 라이선스 하에 공개합니다 <img src = "https://img.shields.io/badge/license-MIT-pink" width=80></img>

* 공유 - 복제, 배포, 포맷 변경, 전송, 전시, 공연, 방송할 수 있습니다.
* 변경 - 리믹스, 변형, 2차적 저작물 작성 및 영리목적의 이용이 가능합니다. 