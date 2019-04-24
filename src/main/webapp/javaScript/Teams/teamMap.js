
var map;
let startPoint;
var marker;

function initMap() {
    //let iniPoint={lat: parseFloat( $("#txtLngLat").val().split(",")[0]), lng: parseFloat($("#txtLngLat").val().split(",")[1])};
    startPoint={lat: 33.64566, lng: -86.6836};

    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 3,
        center: startPoint
    });

}

$(function () {
    $('#myModal').on('show.bs.modal', function (event) {
        let button = $(event.relatedTarget) // Button that triggered the modal
        let teamId = button.data('id') // Extract info from data-* attributes
        let url=location.href+"?teamMapId="+teamId;
        $.getJSON(url)
            .done(data=>{
                data.forEach(item=>{
                    if(item.LngLat){
                        let contactInfo="<div><div><strong>Name</strong><p>"+item.Name+"</p></div>";
                        contactInfo+="<div><strong>Phone</strong><p>"+item.Phone+"</p></div>";
                        contactInfo+="<div><strong>Email</strong><p>"+item.Email+"</p></div>";
                        contactInfo+="<div><strong>Address</strong><p>"+item.Address+"</p></div></div>";

                        let infowindow = new google.maps.InfoWindow({
                            content: contactInfo
                        });
                        let latLang=item.LngLat.split(",");
                        let iniPoint={lat: parseFloat( latLang[0]), lng: parseFloat(latLang[1])};
                        marker = new google.maps.Marker({
                            map: map,
                            draggable: false,
                            animation: google.maps.Animation.DROP,
                            position: iniPoint
                        });

                        marker.addListener('click', function() {
                            infowindow.open(map, marker);
                        });
                    }

                });
            });
    })
});