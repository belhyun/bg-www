<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet"  type="text/css" />
<link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet"  type="text/css" />
<link href="<c:url value="/resources/css/register_guest.css" />" rel="stylesheet"  type="text/css" />
<link href="<c:url value="/resources/css/datepicker.css" />" rel="stylesheet"  type="text/css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore-min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.string/2.3.3/underscore.string.min.js"></script>
<script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCd8g41gqlpEGM2lchBKI_1mcH2MYqcXPY&sensor=false&v=3.exp"></script>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<title>바스켓볼 게스트</title>
</head>
<body>
<div id="wrap">
	<div id="container">
		<%@ include file="find_location.jsp" %>
		<div id="register-guest-form">
			<fieldset>
				<!-- Form Name -->
				<h3>구인등록</h3>
				<hr/>
				<form:form name="registerGuestForm" id="form" method="post" modelAttribute="guest">
				    <div class="form-group">
				      <section>
					      <form:input path="" type="text" class="form-control" placeholder="장소" data-toggle="modal" data-target="#find-location-modal" style="width:inherit;"/>
				      </section>
				      <section id="">
				      	  <!--
					      <button class="btn btn-warning btn-large"  id="" onclick="">
					       	등록
					      </button>
					      -->
				      </section>
				    </div>
				 </form:form>
			 </fieldset>
		 </div>
	</div>
</div>
<!--datepicker
<input type="text" class="span2" value="" id="dpd1" >
$('#dpd1').datepicker(); -->
<script type="text/javascript">
	$(document).ready(function(){
		var mapHandler = (function(){
			var map, center = new google.maps.LatLng(37.478383, 126.916895);
			var marker=new google.maps.Marker({
			    position:center
			});
			(function initialize() {
			  var mapOptions = {
			    zoom: 17,
			    center: center,
			    draggable: false,
			    scrollwheel: false,
			  };
			  //map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
			  //marker.setMap(map);
			}());
			return{ 
				resizeMap : function(callback) {
				   if(_.isUndefined(map)) return;
				   _.delay(function(){
					   google.maps.event.trigger(map, "resize");
					   map.setCenter(center);
					   callback.call(callback);
				   },1000);
				},
				search : function(query){
					$.ajax({
					   url:"/bg-www/location/search",
					   type:"POST",
					   data:{query:query},
					   dataType: "json",
					   success: function(resp){
						   var html = "<table class=\"table\"><tbody>";
						   _.each(resp,function(object){
							  html += "<tr><td>";
							  html += object.name+"("+object.formatted_address+")";
							  html += "</td></tr>";
						   });
						   html += "</tbody></table>";
						   $("#location-suggestions .panel-body").append(html);
					   },
					   error: function(resp){
						   alert("일시적인 장애입니다.");
					   }
				   });
				}
			};
		}());
		$('#find-location-modal').on('show.bs.modal', function() {
		   //mapHandler.resizeMap(function(){
		   //});
		});
		
		$("#find-location-btn").click(function(){
			var query = $("#find-location-modal .modal-body .input-group .form-control").val();
			if(_.string.isBlank(query)){
				alert("장소를 입력해 주세요.");
			}
			mapHandler.search(query);
		});
	});
</script>
</body>
</html>