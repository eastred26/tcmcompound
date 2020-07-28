$(document).ready(function () {
    let compoundId = document.getElementById('compound_id').innerHTML;
    var pngUrl = "http://zcy.ckcest.cn/zcypics/tcmcompound/2d/"+ compoundId + ".png";
    $('#2d-pic').attr("src", pngUrl);

    let element = $('#3d-container');
    let config = { backgroundColor: 'white' };
    let viewer = $3Dmol.createViewer( element, config );
    let sdfUrl = "http://zcy.ckcest.cn/zcypics/tcmcompound/3d/"+ compoundId + ".sdf";
    jQuery.ajax( sdfUrl, {
        success: function(data) {
            let v = viewer;
            v.addModel( data, "sdf" );                       //load data
            v.setStyle({'sphere':{radius:0.3} ,'stick':{radius:0.2, 'colorscheme':'cyanCarbon'}});
            v.zoomTo();                                      //set camera
            v.render();                                      //render scene
        },
        error: function(hdr, status, err) {
            alert( "Unable to generate 3D view of this element.");
        },
    });
});