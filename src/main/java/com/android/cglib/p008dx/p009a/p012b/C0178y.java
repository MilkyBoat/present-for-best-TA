package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p020d.C0304r;

/* renamed from: com.android.cglib.dx.a.b.y */
public enum C0178y implements C0304r {
    TYPE_HEADER_ITEM(0, "header_item"),
    TYPE_STRING_ID_ITEM(1, "string_id_item"),
    TYPE_TYPE_ID_ITEM(2, "type_id_item"),
    TYPE_PROTO_ID_ITEM(3, "proto_id_item"),
    TYPE_FIELD_ID_ITEM(4, "field_id_item"),
    TYPE_METHOD_ID_ITEM(5, "method_id_item"),
    TYPE_CLASS_DEF_ITEM(6, "class_def_item"),
    TYPE_MAP_LIST(4096, "map_list"),
    TYPE_TYPE_LIST(4097, "type_list"),
    TYPE_ANNOTATION_SET_REF_LIST(4098, "annotation_set_ref_list"),
    TYPE_ANNOTATION_SET_ITEM(4099, "annotation_set_item"),
    TYPE_CLASS_DATA_ITEM(8192, "class_data_item"),
    TYPE_CODE_ITEM(8193, "code_item"),
    TYPE_STRING_DATA_ITEM(8194, "string_data_item"),
    TYPE_DEBUG_INFO_ITEM(8195, "debug_info_item"),
    TYPE_ANNOTATION_ITEM(8196, "annotation_item"),
    TYPE_ENCODED_ARRAY_ITEM(8197, "encoded_array_item"),
    TYPE_ANNOTATIONS_DIRECTORY_ITEM(8198, "annotations_directory_item"),
    TYPE_MAP_ITEM(-1, "map_item"),
    TYPE_TYPE_ITEM(-1, "type_item"),
    TYPE_EXCEPTION_HANDLER_ITEM(-1, "exception_handler_item"),
    TYPE_ANNOTATION_SET_REF_ITEM(-1, "annotation_set_ref_item");
    

    /* renamed from: w */
    private final int f1399w;

    /* renamed from: x */
    private final String f1400x;

    /* renamed from: y */
    private final String f1401y;

    private C0178y(int i, String str) {
        this.f1399w = i;
        this.f1400x = str;
        if (str.endsWith("_item")) {
            str = str.substring(0, str.length() - 5);
        }
        this.f1401y = str.replace('_', ' ');
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return this.f1401y;
    }

    /* renamed from: b */
    public int mo1516b() {
        return this.f1399w;
    }

    /* renamed from: c */
    public String mo1517c() {
        return this.f1400x;
    }
}
