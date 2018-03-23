<script type="text/html" id="richText">
    <div>
        <input type="hidden" name="{{d.name}}" id="content"/>
       <textarea class="layui-textarea layui-hide" id="richTextId" >
        {{#  if(d.value != 'null'){ }}
         {{d.value}}
        {{#  } }}</textarea>
    </div>
</script>
<script type="text/javascript">
    var layedit;
    var editIndex;
    var $;
    layui.use([ 'layedit','upload'], function() {
        // 操作对象
        layedit = layui.layedit;
        $=layui.jquery;
        editIndex = layedit.build('richTextId', {
            uploadImage: {url: '/public/file/uploadRichTextEditFile.do', type: 'post'}
        });
        layedit.sync(editIndex);
        function syncData() {
            console.log(layedit.getContent(editIndex));
            $("#content").val("");
            $("#content").val(layedit.getContent(editIndex));
            setTimeout(function () {
                syncData();
            },1000);
        } ;
        syncData();
    });
</script>
