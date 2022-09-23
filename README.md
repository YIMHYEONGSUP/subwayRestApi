# 아윌비 과제 테스트

# 다음을 Rest Api 로 구현하시오

![image](https://user-images.githubusercontent.com/101487300/191496398-715ccf61-4c09-4fa1-a2e3-13a6e5baf734.png)


# 테스트 방법
Swagger ( route-controller ) , post man { "line_start":"판교" , "line_end":"삼성" }

# 2022 09 20 
Station , Line 값을 PostConstruct로 세팅

# 2022 09 21
재귀함수를 이용하여 최단시간 최단루트 Post man 테스트 완료
(구현을 완료하였으니 효율성을 높이기 위해 리팩토링)

# 2022 09 22 
최단거리 탐색 시 최소 비용과 현재 비용 비교 조건 추가 
탐색횟수 88회 -> 27회
다익스트라 구현

# 2022 09 23 
다익스트라 알고리즘으로 최단루트 탐색 실패 종결
