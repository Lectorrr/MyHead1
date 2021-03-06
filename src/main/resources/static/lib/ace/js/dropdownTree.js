/*
 * author: Lin Wei
 * email: wataru19831111@hotmail.com
 * Date: 2014-05-22
 * version 0.1 (single select only)
 * depend on jQuery,Bootstrap(optional),select2 & zTree
 * 
 * 
 * This software is licensed under the Apache License, Version 2.0 (the "Apache License") or the GNU
 General Public License version 2 (the "GPL License"). You may choose either license to govern your
 use of this software only upon the condition that you accept all of the terms of either the Apache
 License or the GPL License.

 You may obtain a copy of the Apache License and the GPL License at:

 http://www.apache.org/licenses/LICENSE-2.0
 http://www.gnu.org/licenses/gpl-2.0.html

 Unless required by applicable law or agreed to in writing, software distributed under the
 Apache License or the GPL License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 CONDITIONS OF ANY KIND, either express or implied. See the Apache License and the GPL License for
 the specific language governing permissions and limitations under the Apache License and the GPL License.
 */

var DropdownTree = function (setting) {
    this.config = setting;
    if (this.config.children == null) {
        this.config.children = "children"
    }
};

DropdownTree.prototype = $
    .extend(
    new Select2.class.single(),
    {
        treeNode: null,
        elName: null,
        selectId: 'selectId' + parseInt(1000 * Math.random()),
        createContainer: function () {
            var container = $(document.createElement("div"))
                .attr({
                    "class": "select2-container"
                })
                .html(
                [
                    "<a href='javascript:void(0)' class='select2-choice' tabindex='-1'>",
                    "   <span class='select2-chosen'>&#160;</span><abbr class='select2-search-choice-close'></abbr>",
                    "   <span class='select2-arrow' role='presentation'><b role='presentation'></b></span>",
                    "</a>",
                    "<label for='' class='select2-offscreen'></label>",
                    "<input class='select2-focusser select2-offscreen' type='text' aria-haspopup='true' role='button' />",
                    "<div class='select2-drop select2-display-none'>",
                    "   <div class='select2-search'>",
                    "       <label for='' class='select2-offscreen'></label>",
                    "       <input type='text' autocomplete='off' autocorrect='off' autocapitalize='off' spellcheck='false' class='select2-input' role='combobox' aria-expanded='true'",
                    "       aria-autocomplete='list' />",
                    "   </div>",
                    "   <ul class='select2-results' role='listbox'>",
                    "   </ul>",
                    "	<ul id='orgDropDownTree' class='ztree' style='width:auto;height:auto;max-height:330px;border:0;overflow-y:auto;margin-top:0'></ul>",
                    "</div>"
                    //不采用自动新建标签的方式，以下代码注释
                    //,
                    //"<input id='" + this.selectId + "' type='hidden' />"
                ]
                    .join(""));
            return container;
        },
        initContainer: function () {
            var self = this;
            self.elName = self.config.elName;
            Select2.class.single.prototype.initContainer.call(this);
            this.treeContainer = self.results.next();
            /*
             * this.treeBtn=this.container.find("b");
             * this.treeBtn.on("click",function(event){
             * self.showTree(self) });
             */
            this.selection.bind("focus", function () {
                // self.treeContainer.hide();
                self.search.parent().show();
                // self.showTree(self)
                // self.results.show();
            });
            //alert("ini");
        },
        updateResults: function () {
            Select2.class.single.prototype.updateResults.call(this);
            var search = this.search;
            if (search.val().length >= this.opts.minimumInputLength) {
                this.treeContainer.hide();
            } else {
                this.treeContainer.show();
            }
            //alert("up");
        },
        opening: function () {
            if (this.config.ajax) {
                Select2.class.single.prototype.opening.call(this);
            } else {
                Select2.class.single.prototype.opening.call(this);
                this.search.parent().hide();
                this.results.hide();
            }
            this.showTree();
        },
        showTree: function () {
            var self = this;
            this.treeContainer.show();

            var filter = function (treeId, parentNode, childNodes) {
                if (!childNodes)
                    return null;
                for (var i = 0, l = childNodes.length; i < l; i++) {
                    childNodes[i].name = childNodes[i].name
                        .replace(/\.n/g, '.');
                }
                return childNodes;
            };

            var beforeAsync = function (treeId, treeNode) {
                if (treeNode && !treeNode.id) {
                    treeNode.id = treeNode.name;
                }
            };

            var beforeClick = function (treeId, treeNode) {
                // var check = (treeNode && !treeNode.isParent);
                var check = (treeNode && !treeNode.disSelected);
                if (!check)
                    alert("Can not select this node...");
                return check;
            };

            var onClick = function (e, treeId, treeNode) {
                self.treeNode = treeNode;
                self.data({
                    id: treeNode.id,
                    text: treeNode.name,
                    icon: treeNode.icon
                });
                self.onSelect({
                    id: treeNode.id,
                    text: treeNode.name,
                    icon: treeNode.icon
                });
                self.treeContainer.hide();
                self.close();
                self.focus();

                //不采用自动新建标签的方式，以下代码注释
                // 赋值
                //self.container.find('#' + self.selectId).attr(
                //'name', self.elName).val(treeNode.id);

                $('#' + self.elName).val(treeNode.id);
            };

            var onCheck = function(event, treeId, treeNode){
                $('.chosen-org-div').show();
                if(treeNode.checked){
                    if($('.chosen-org-ul').find('#' + treeNode.id).length < 1){
                        $('.chosen-org-ul').append('<li id="' + treeNode.id + '" class="search-choice" data-id="' + treeNode.id + '"><span>' + treeNode.name + '(' + treeNode.getParentNode().name + ')' + '</span><a class="search-choice-close" data-option-array-index="2"></a></li>');
                        $('.search-choice-close').on('click', function(){
                            $(this).parent().remove();
                            if($('.chosen-org-ul').find('li').length < 1){
                                $('.chosen-org-div').hide();
                            }
                        });
                    }
                } else {
                    $('.chosen-org-ul').find('#' + treeNode.id).remove();
                    if($('.chosen-org-ul').find('li').length < 1){
                        $('.chosen-org-div').hide();
                    }
                }
            };

            var onAsyncSuccess = function (event, treeId, treeNode,
                                           msg) {
                /*console.log(treeNode);
                var treeObj = $.fn.zTree.getZTreeObj("orgDropDownTree");
                if($('.chosen-org-ul').find('#' + treeNode.id) > 0){
                    treeObj.checkNode(treeNode, true, false);
                } else {
                    treeObj.checkNode(treeNode, false, false);
                }*/
            };

            var onNodeCreated = function (event, treeId, treeNode) {
                if (treeNode.hidden) {
                    $("#" + treeNode.tId).css({
                        display: "none"
                    });
                }
            };

            var setting = {
                view: {
                    dblClickExpand: false
                },
                check: {
                    enable: true,
                    // 设置父子关联关系（被勾选时：不关联父  不关联子; 取消勾选时：不关联父  不关联子）
                    chkboxType : {"Y": "", "N": ""},
                },
                async: {
                    enable: !!this.config.tree.url,
                    url: this.config.tree.url,
                    // autoParam:["id", "name=n", "level=lv"],
                    autoParam: ["id=parentId"],
                    // otherParam:{"otherParam":"zTreeAsyncTest"},
                    dataFilter: filter
                },
                data: {
                    keep: {
                        leaf: true,
                        parent: true
                    },
                    key: {
                        children: this.config.tree.children
                    },
                    simpleData: {
                        enable: true,
                        idKey: 'id',
                        pIdKey: 'parentId',
                    }
                },
                callback: {
                    beforeAsync: beforeAsync,
                    beforeClick: beforeClick,
                    onClick: onClick,
                    onCheck: onCheck,
                    onAsyncSuccess: onAsyncSuccess,
                    onNodeCreated: onNodeCreated
                }
            };

            setting = $.extend(setting, this.config.tree);
            $.fn.zTree.init(this.treeContainer, setting);
            $(".select2-search").remove();
        }
    });

$.fn.dropdownTree = function () {
    var args = Array.prototype.slice.call(arguments, 0), opts, multiple;

    function format(data) {
        if (!data.icon)
            return data.text;
        return "<img  src='" + data.icon + "'/> " + data.text;
    }

    this.each(function () {
        if (args.length === 0 || typeof (args[0]) === "object") {
            var defaults = {
                formatNoMatches: function () {
                    return "没找到对应值"
                },
                formatInputTooShort: function (input, min) {
                    return "还需要输入" + (min - input.length) + "个字符"
                },
                formatSelectionTooBig: function (limit) {
                    return "只能选择" + limit + "条数据"
                },
                formatSearching: function () {
                    return "正在搜索，请稍候..."
                },
                formatResult: format,
                formatSelection: format,
                minimumInputLength: 2,
                allowClear: true,
                placeholder: args[0].ajax ? "输入文字进行搜索" : "",
                placeholderOption: "first"
            };
            opts = args.length === 0 ? defaults : $.extend(defaults, args[0]);
            opts.element = $(this);
            if (opts.element.get(0).tagName.toLowerCase() === "select") {
                multiple = opts.element.prop("multiple");
            } else {
                multiple = opts.multiple || false;
                if ("tags" in opts) {
                    opts.multiple = multiple = true;
                }
            }

            /*
             * select2 = multiple ? new window.Select2["class"].multi() : new
             * window.Select2["class"].single(); select2.init(opts);
             */
            // console.log(opts);
            var dropdownTree = new DropdownTree(args[0]);
            dropdownTree.init(opts);
        }
    });
    return this;
};