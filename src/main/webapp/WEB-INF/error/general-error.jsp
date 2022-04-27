<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/error.css" >
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Cinzel&family=Laila:wght@400;500&family=Montserrat+Alternates:wght@400;500&family=Tapestry&display=swap" rel="stylesheet">
<script src="../js/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>

<title>General Error</title>
</head>
<body>
	<div class="bg">
  <div class="content">
    <div class="sever404">
        <img src="https://4.bp.blogspot.com/-1SdlwgNnm-s/WwJZxJ_hwoI/AAAAAAABMHg/YKObYTYyZGIL5Qm0LG4x_kHrxkBIjoILgCLcBGAs/s300/computer_server_chara4_panic.png" >
      </div>
    <div class="txt">
      <div class="text">
        <p class="title">Oops&nbsp;! &nbsp;:c</p>
        <p class="desc">It seems some problems happened, <br/>
          please check if url or data you key in is correct. <br/>
          If it keeps going wrong, <br/>
          feel free to contact me by clicking Support button !
        </p>
        <div class="status" id="status">
        	<p> Http Status : {{ keyin }}</p>
        </div>
      </div>     
      <div class="btns">
        <button onclick="location.href='${ pageContext.request.contextPath }/convert/'" class="back" >
          Back to Retry
        </button>
        <button onclick="window.open('https://marshmallow-qa.com/y_vacc?utm_medium=url_text&utm_source=promotion', '_blank')" class="conn">
          Support
        </button>
      </div>
     </div>
  </div>
  <div class="imgs">
      <div class="fire_pos">    
        <div class="fire">
          <img src="https://3.bp.blogspot.com/-bTpI2R-Kxe0/Viio_KII7WI/AAAAAAAAztM/oNokVj_uJyI/s400/honoo_hi_fire.png">
        </div>
        <div class="computer">
          <img src="https://4.bp.blogspot.com/-OMv8X-XdJ6g/WR_LWn9MYfI/AAAAAAABEfY/O2sTbkdmycUdxngDagTTbfNxOXTme0NgACLcB/s500/wakamono_hanareru_pc.png">
        </div>
        <!--     <div class="sever500">
          <img src="https://4.bp.blogspot.com/-Aazr2nkXjSw/WwJZw9qgB5I/AAAAAAABMHY/gFWd5cDktMosv_V0k_VtOYvWgKJnZ_GwQCLcBGAs/s300/computer_server_chara3_bad.png">
        </div> -->
      </div>
    </div>
</div>
	
</body>

<script type="text/javascript">
fetch('window.location.href')
	.then(res => {
		console.log(res.status); 
		var status = new Vue({
			el:'#status',
			data:{
				keyin: res.status,
			},
		});
	    })
		.catch(function(error) {
			console.log(error);
	})
</script>

</html>