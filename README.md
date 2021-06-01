## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

## 게임 설명
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

같은 수가 같은 자리에 있으면 스트라이크,  
다른 자리에 있으면 볼,  
같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고,  
그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.

e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크,  
456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱  

위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다.  
컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 

게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고,  
컴퓨터는 입력한 숫자에 대한 결과를 출력한다.

이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.  
게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

# To-Do list

0. 객체 구조  
    0.1 Balls(3자리)  
    0.2 Ball (각 자리)
   

1. 입력
    1.1 사용자의 입력은 3자리  
    1.2 각 자리는 1~9의 정수다.   
    1.3 각 자리의 수는 서로 다르다.  


2. 아웃풋 조건  
   (전제: 컴퓨터의 정답=answer, 사용자 입력=input)  
   2.1 자리수 같다 && 값 같다 = 스트라이크  
   2.2 자리수 다르다 && 값 같다 = 볼  
   2.3 0 스트라이크, 0볼 = 낫싱
   
3. 게임 종료
