$(document).ready(function() { 
    $('input[name=options-outlined]').change(function(){
      if($('input[name=options-outlined]').is(':checked')){
         $('form').submit();
      }
    });
    // $('input[name=radioBtn1]').change(function(){
    // if($('input[name=radioBtn1]').is(':checked')){
    //      $('form').submit();
    //   }
    // });    
   });