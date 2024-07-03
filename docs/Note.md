- Item : 객체 - 상품명+가격+수량
  - ItemName : 상품명
  - ItemPrice : 상품 가격
  - ItemInventory : 상품 수량
- ItemMatcher : List<String,items>로 관리하고 입력된 값을 찾는다.
- 

- VendingMachineCasher : 보유하고 있는 금액을 관리한다.
- UserCasher : 사용자가 투입한 금액을 관리한다. 잔돈을 계산한다

- CashValidator(i) : 10의 단위, 최소 최대
---
- 투입 금액을 입력하면 바로 잔돈 계산을 해야될거같으넫 아닌가??최니까 합쳐서?

- 잔돈이 어떤의미야?
  - 구매하고 남은돈의 가격에서만 자판기가 가지고있는 돈을 주면된다.
  - 최종 남은 금액은 - 더이상 삼품을 살 수 없을 때
  - 그럼 그 출력된 최종 금액만큼 자판기의 잔동을 주면 된다.
  - 자판기 잔돈 < 최종 금액 = 자판기 잔돈을 다 출력
  - 자판기 잔돈 > 최종 금액 = 죄소한의 동전 개수로 출력


- 잔돈을 출력하기 위해서는? => UserCasher 역할
1. 남은 금액이 유효한지 확인한다. = > 꼐속 해야됨
2. 자판기의 금액과 최종 남은 금액을 비교한다.
3. 최소한의 동전 개수로 잔돈을 출한다.  

=> 투입 금액이 입력되는 순간부터 계속 해야됨

----
- 잔돈 반환
1. userchah 에서 get 해오기?
   1. userCash.getBalance()
   2. calculate
2. calculate에서 get해오기?

---
### 리팩토링
1. VendingMachine Coin 리스트 랜덤으로 가져오는 기능 인터페이스?
2. CashChangeCalculator 활용하기
3. ItemMatcher 로직 리팩토링
4. ItemParser 이해하기
5. 래덤 동전 리스트, 최소 동전 반환 이해하기


### 변수
### 에러 메시지 정리
### 왜 랜덤으로 안되지