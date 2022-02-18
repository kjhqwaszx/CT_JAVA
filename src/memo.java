https://velog.io/@alstjdwo1601/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EA%B4%80%EB%A0%A8-%ED%8C%81

< Char >
 - char 는 비교가 가능하다.
   if('a' < 'b') / if ('a'=='a')  => true   String의 경우 .equals() 로 비교를 해야한다.
 - (char) ('a' + 1) => 'b'  아스키코드 사용 가능

<String>
 String str = "AaBb";
 String str2 = "1234";
 - str + str2 => AaBb1234 출력
 - str.length() => 문자열 길이
 - str.toLowerCase() => 소문자
 - str.toUpperCase() => 대문자
 - str.indexOf("a") => a 의 index 출력
 - Integer.parseInt(str2) => 정수형 1234 변환
 - str.charAt(index) => index 번째 String값을 char로 출력
 - String[] arr = str.split(""); => str을 배열로 저장.{"A","a","B","b"}
 - char[] cArr = str.toCharArray(); => {'A','a', 'B', 'b'}
 - str.substring(idx) => index를 포함한 부분부터 끝까지 추출
   str.substring(idx1,idx2) => idx1 부터 idx2 미만까지 추출
   str2.subString(0,2) + '3.5' + str2.subString(3) => 2번 index 값 변경
   
   [StringBuilder] : 문자열을 효과적으로 사용할 수 있도록 도와준다. toString()으로 문자열로 변환해주어야한다. ex) 문자열 붙이기, 역순출력 등등
    - StringBuilder sb = new StringBuilder();
    - sb.append('a'), sb.append('b') => 문자 추가
    - sb.deleteChartAt(1) => 1번 인덱스 삭제
    - sb.setChartAt(0,'A') => 0번 인덱스 값 변경
    - sb.insert(index, item) => index 위치에 item삽입
    - String sumString = sb.append(str).append(str).toString();
    - String reStr = sb.append(str).reverse().toString(); => str값 역순으로 출력
      = String reStr = new StringBuilder(str).reverse().toString(); => append대신 생성자로 바로 만드는 방법
    


< Array >
String str = "1234";
int[] arr = new arr[10];
int[] tmp = new arr[10];
 - arr.length => arr의 길이를 출력
 - Arrays.sort(arr) => 배열을 정렬한다.
 - Arrays.sort(arr,Collections.reverseOrder()); => 배열 내림차순 정렬
 - tmp = Arrays.copyOfRange(arr,0,2) => arr 인덱스 0,1의 값을 tmp에 복사한다.
 - Arrays.binarySearch(arr,3); => 이진탐색을 통해 찾고자하는 값의 인덱스를 리턴한다. 이진탐색이기 때문에 배열은 sort 되어있어야한다.
 - ArrayList<String> AL = new ArrayList<String>(Arrays.asList(arr));  => 배열을 ArrayList 로 변환
 - ArrayList<String> AL = new ArrayList<String>(Arrays.asList(str.split(""))); => 문자열을 ArrayList 로 변환

< ArrayList >
  arr = {1,2,3,4,5}  / arr2 = {}
 - arr.add(index,item) => 해당 인덱스에 데이터 추가
 - arr.add(item) => 마지막 인덱스에 데이터 추가
 - arr.remove(index) => 해당 인덱스 데이터 삭제
 - arr.get(index) => 해당 인덱스 데이터 추출
 - arr.indexOf(item) => 데이터의 인덱스 추출
 - arr.subList(index1,index2) => arr의 index 1 부터 index2 바로 전까지 추출
 - arr.sort(null) => 오름차순으로 정렬한다.
 - arr2.addAll(arr) => arr 깊은 복사
 - String[] strArr = arr.toArray(new String[arr.size()])

 < Collections >
  - Collections.swap(arr,index1,index2) => ArrayList의 index1,2 값 변경


< Map >
 Map<String,Integer> map = new HashMap<String,Integer>();

 - map.put("str",1) => key, value를 넣는다.
 - map.get("str") => key값을 추출한다.
 - map.containsKey("str"); => map에 키값 "str"이 존재하는지 true/false
 - map.size()

 [Iterator] : 1. map명.keySet().iterator()를 사용해 반복자를 생성한다.
              2. 반복자.hasNext()를 통해 다음 값이 존재하는지 확인한다.
              3. 반복자.next()를 통해 참조값을 가져온다.
 Map<String,Integer> map = new HashMap<String,Integer>();
 Iterator<String> it = map.keySet().iterator();
 while(it.hasNext()){
    String key = it.next();
    int value = map.get(key);
 }


