
    var map;
    let startPoint={lat: 33.64566, lng: -86.6836};
    var marker;

    function initMap() {
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
    }

    function toggleBounce() {
        if (marker.getAnimation() !== null) {
            marker.setAnimation(null);
        } else {
            marker.setAnimation(google.maps.Animation.BOUNCE);
        }
    }