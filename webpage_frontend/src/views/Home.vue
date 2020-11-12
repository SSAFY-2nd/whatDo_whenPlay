<template>

  <html>
    
    <div class="home">

    <!-- 사진 -->
    <section id="intro">
      <div id="intro-background"></div>
      <div id="intro-tagline">
        <h1>놀면 뭐하니?!</h1>
      </div>
    </section>

    <main class="page-content">
    <!-- 소개글 -->
      <div class="page-container">
        <h1>About 놀면뭐하니</h1>
        <hr />
        <h2>뭐하고 놀지 뭐 먹을지 궁금해??</h2>

        <p>전철역 근처에서 만나는 데 근처 핫 플레이스(먹거리 / 놀거리)를 알고 싶다면?!</p>
        <p>친구와 만날 때 취향을 고려해서 추천해주는 서비스가 필요하다면?!</p>
        <p>내가 예전에 방문했던곳을 다시 가고싶거나 추천받고 싶을때 좀 더 편하게 하고싶다?!</p>
        <p>놀면 뭐하니?! 를 이용해보세요 오로지 놀고 먹는것에만 집중할 수 있습니다!!</p>
      
      </div>
      <!-- Service -->
      <section id="services" class="sec-services">
        <div class="container">
          <h1>Services</h1>
          <hr/>
          <div class="row">
            <div class="col-sm-4">
              <div class="col" style="right:30px">
                <v-icon size="100" >mdi-nutrition</v-icon>
              </div>
              <h2 class="h3"> 취향별 추천</h2>
              <p>취향별로 놀거리와 먹거리를 추천해드립니다</p>
            </div>

            <div class="col-sm-4">
              <div class="col" style="right:30px">
                <v-icon size="100" >mdi-kabaddi</v-icon>
              </div>
              <h2 class="h3"> 같이 놀기</h2>
              <p>친구와의 취향을 자동으로 분석해 싸우지 않아요</p>
            </div>
            <div class="col-sm-4">
              <div class="col" style="right:30px">
                <v-icon size="100" >mdi-calendar-clock</v-icon>
              </div>
              <h2 class="h3"> 즐겨 찾기</h2>
              <p>맛있게 먹었던곳을 손쉽게 저장</p>
            </div>
          </div>
        </div>
      </section>
      <!-- photo -->
      <section id="folio" class="sec-folio">
        <div class="container">
          <h1>APP Maker</h1>
          <hr />
          <div class="row">
            <div class="col-md-4">
              <img class="center-block" src="../assets/maker/jaehyun_R.jpg" alt="By Håkon Sataøen" />
              <v-icon size="20">mdi-account-circle</v-icon> Kim jae hyun <br>
              <v-icon size="20">mdi-badge-account-horizontal </v-icon> 인성문제없어 <br>
              <v-icon size="20">mdi-cellphone-iphone</v-icon> 010 9961 3909           
            </div>
            <div class="col-md-4">
              <img class="center-block" src="../assets/maker/gunho_R.jpg" alt="By Samuel Zeller" />
              <v-icon size="20">mdi-account-circle-outline</v-icon> Lim Gun ho <br>
              <v-icon size="20">mdi-badge-account-horizontal </v-icon> 인성문제있어 <br>
              <v-icon size="20">mdi-cellphone-iphone</v-icon> 010 1004 1004     
            </div>
            <div class="col-md-4">
              <img class="center-block" src="../assets/maker/jeonghyun_R.jpg" alt="By Scott Webb" />
              <v-icon size="20">mdi-account-circle</v-icon> Kim Jeong hyun <br>
              <v-icon size="20">mdi-badge-account-horizontal </v-icon> 우리 모두 취업하자 <br>
              <v-icon size="20">mdi-cellphone-iphone</v-icon> 010 7777 7777   
            </div>
          </div>

          <div class="row">
            <div class="col-md-4">
              <img class="center-block" src="../assets/maker/juho_R.jpg" alt="By Daniel Lozano Valdés" />
              <v-icon size="20">mdi-account-circle-outline</v-icon> Woo ju ho <br>
              <v-icon size="20">mdi-badge-account-horizontal </v-icon> 싸피3기 13반 반장 영원하라 <br>
              <v-icon size="20">mdi-cellphone-iphone</v-icon> 010 1234 4321   
            </div>
            <div class="col-md-4">
              <img class="center-block" src="../assets/maker/sanghyuk_R.jpg" alt="By Scott Webb" />
              <v-icon size="20">mdi-account-circle</v-icon> Baek Sang hyuk<br>
              <v-icon size="20">mdi-badge-account-horizontal </v-icon> 미래의 개발자 마스터 <br>
              <v-icon size="20">mdi-cellphone-iphone</v-icon> 010 5252 5252   
            </div>
            <!-- <div class="col-md-4">
              <img class="center-block" src="../assets/trainer/trainer6_R.jpg" alt="By Daniel Lozano Valdés" />
              <v-icon size="20">mdi-account-circle-outline</v-icon> Jo Je Hyeong <br>
              <v-icon size="20">mdi-badge-account-horizontal </v-icon> ebro <br>
              <v-icon size="20">mdi-cellphone-iphone</v-icon> 010 9999 9999   
            </div> -->
          </div>
        </div>
      </section>
	  </main>
  </div>
  </html>
  
</template>

<script>
// @ is an alias to /src

import HelloWorld from '@/components/HelloWorld.vue'


//import $ from 'jquery';


export default {
  name: 'Home',
  components: {
    HelloWorld
  },

  created(){
    window.addEventListener('scroll', this.handleScroll);

    $(window).scroll(function() {
    var scroll = $(window).scrollTop();
    $("#intro-background").css("transform","translateY(" +  (scroll/2)  + "px)");    
    });
  }
  
}
</script>


<style scoped>


body {
    font-size: 100%;
    font-family: "Open Sans", sans-serif;
    color: #f35535;
    background-color: #2e313d;
}
html * {
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}
body {
    line-height: 1;
}


#intro {
    position: absolute;
    /*position: fixed;*/
    top: 0;
    left: 0;
    width: 100%;
    height: 700px;
    margin-top: 0;
}

#intro #intro-background {
    height: 100%;
    width: 100%;
    /* background: url("http://www.hdwallpapers.in/walls/milky_way_sky-wide.jpg") no-repeat center center; */
    background: url("../assets/img/mainpage_img5.jpg") no-repeat center center;
    /* background: url("../assets/img/benchpress_wallpaper.jpg") no-repeat center center; */
    background-size: cover;
    box-shadow: 0 0 30px rgba(0, 0, 0, 0.5);
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}

#intro #intro-tagline{
    position: absolute;
    width: 90%;
    max-width: 1170px;
    left: 50%;
    top: 45%;
    bottom: auto;
    right: auto;
    -webkit-transform: translateX(-50%) translateY(-50%);
    -moz-transform: translateX(-50%) translateY(-50%);
    -ms-transform: translateX(-50%) translateY(-50%);
    -o-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
    color: white;
    font-size: 20px;
    font-size: 1.5rem;
    font-weight: 300;
    text-align: center;
}

#intro h1 {
    font-family: "Open Sans", helvetica, arial, sans-serif;
    text-transform: uppercase;
    font-size: 1.8em;
    font-weight: 300;
    text-align: center;
    color: #ffffff;
    text-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
}

.page-content {
    position: relative;
    padding: 2em 0;
    line-height: 1.8;
    color: #65676f;
    font-weight: 100;
    /* background-color: #E6F6F4; */
    background-color: #ffffff;
    z-index: 2;
}

.page-content::before {
    content: '';
    position: absolute;
    bottom: 100%;
    left: 0;
    width: 100%;
    height: 50px;
    background: -webkit-linear-gradient( bottom , rgba(46, 49, 61, 0.5), rgba(46, 49, 61, 0));
    background: linear-gradient(to top, rgba(46, 49, 61, 0.5), rgba(46, 49, 61, 0));
}

@media only screen and (min-width: 1170px) {
.page-content {
    padding: 4em 0;
    margin-top: 570px;
 }
}

@media only screen and (min-width: 768px) { 
.cd-content {
    line-height: 1.8;
 }
}

.page-container {
    width: 90%;
    max-width: 768px;
    margin: 0 auto;
}

.page-container::after {
    content: '';
    display: table;
    clear: both;
}

@media only screen and (min-width: 1170px) {
.page-content p {
    font-size: 20px;
    font-size: 1.25rem;
 }
}

@media only screen and (min-width: 768px) {
.page-content h2 {
    font-size: 30px;
    font-size: 1.875rem;
 }
}

.page-content h2 {
    margin: 2em 0;
    /* font-size: 60px; 20 */
    /* font-size: 1.25rem; */
}

.page-content p {
    margin: 1em 0;
}
/* About */


/*Services*/

/* .sec-services {
  background: #f9f9f9;
} */

.sec-services i {
  display: block;
  margin: auto;
  width: 45px;
}

.sec-services .fa-paint-brush {
  width: 64px;
}

.sec-services .fa-code {
  width: 68px
}

.sec-services h2 {
  margin: 1em 0;
}

/* image layout*/
.sec-folio .row {
  /* margin-top: 2em; */
  margin-bottom: 1em;
  font-size: 16px;
  font-size: 1.00em;
}

.sec-folio img {
  max-width: 100%;
}


</style>