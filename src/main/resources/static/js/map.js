map = new ol.Map({
    target: 'map-layer',
    layers: [
        new ol.layer.Tile({
            source: new ol.source.OSM()
        })
    ],
    view: new ol.View({
        center: ol.proj.fromLonLat([19.1,52]),
        zoom: 6.45
    })
});

