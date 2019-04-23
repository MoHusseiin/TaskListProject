
    var map;
    let startPoint;
    var marker;

    function initMap() {
        //let iniPoint={lat: parseFloat( $("#txtLngLat").val().split(",")[0]), lng: parseFloat($("#txtLngLat").val().split(",")[1])};
         startPoint=($("#txtLngLat").val())?{lat: parseFloat( $("#txtLngLat").val().split(",")[0]), lng: parseFloat($("#txtLngLat").val().split(",")[1])}:{lat: 33.64566, lng: -86.6836};

        map = new google.maps.Map(document.getElementById('map'), {
            zoom: 8,
            center: startPoint
        });

        marker = new google.maps.Marker({
            map: map,
            draggable: true,
            animation: google.maps.Animation.DROP,
            position: startPoint
        });
        marker.addListener('click', toggleBounce);
        marker.addListener('drag', handleEvent);
        marker.addListener('dragend', handleEvent);
    }
    function handleEvent(event) {
        $("#txtLngLat").val(event.latLng.lat()+","+event.latLng.lng());
    }
    function toggleBounce() {
        if (marker.getAnimation() !== null) {
            marker.setAnimation(null);
        } else {
            marker.setAnimation(google.maps.Animation.BOUNCE);
        }
    }