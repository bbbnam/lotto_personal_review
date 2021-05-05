# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

### 요구사항 정리 ✔
* 로또 구입 금액을 입력하면 -> 구입 금액에 해당하는 로또 발급
* 로또 1장 가격은 1000원
* 로또 구매는 자동으로 이루어짐(번호 선택이 자동이라는 의미)
* 지난 주 당첨번호를 입력받음
* 지난 주 당첨번호와 유저가 구매한 당첨번호를 비교하여 당첨 통계를 구함
* 총 수익률 표시 (기준은 1)

### 힌트
 >- 로또 자동 생성은 Collections.shuffle() 메소드 활용  
 >- Collections.sort() 메소드를 활용 하여 정렬이 가능 -> 번호 정렬을 의미?  
 >- ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단 가능
 