# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

### 05-07 간단회고
- Collections.unmodifiableList(list) 를 통해서 일급 컬렉션을 외부에서 받아서 처리하고
  다시 getter를 통해 리턴해줄때에도 이와같이 리턴을 해주었었는데,
  외부에서 들어오는 즉, 원본 list에 추가나 수정이 이루어지면, Collections.unmodifiableList는
  참조를 끊어주는건 아니기 때문에 내부에 저장되어있던 (final로 선언된) list도 변경이 되어버린다.
  즉, final 선언이 되었어도 애초에 원본 리스트가 수정이 되는것에 대한 변경 금지가 아니라
  final로 선언된 리스트에 최초 초기화 된 시점(객체 생성되어 리스트를 주입받은 시점) 이후에
  final로 선언된 리스트 변수 (일급 컬렉션으로 포장된 리스트를 의미) 에 추가적인 변경이 이루어지지
  않게끔 해주는 것이다. 
  참고 : https://ecsimsw.tistory.com/entry/unmodifiableList%EC%9D%80-%EB%A7%8C%EB%8A%A5%EC%9D%B4-%EC%95%84%EB%8B%88%EB%8B%A4