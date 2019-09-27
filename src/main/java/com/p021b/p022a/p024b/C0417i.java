package com.p021b.p022a.p024b;

/* renamed from: com.b.a.b.i */
public class C0417i extends C0416h {

    /* renamed from: f */
    private static C0416h f3003f;

    /* renamed from: g */
    private static final String[] f3004g = "and|break|case|continue|default|defer|do|else|elseif|end|false|for|function|goto|if|in|lambda|local|nil|not|or|repeat|return|switch|then|true|until|when|while".split("\\|");

    /* renamed from: h */
    private static final String[] f3005h = "self|__add|__band|__bnot|__bor|__bxor|__call|__close|__concat|__div|__eq|__gc|__idiv|__index|__le|__len|__lt|__mod|__mul|__newindex|__pow|__shl|__shr|__sub|__tostring|__unm|_ENV|_G|assert|collectgarbage|dofile|error|findtable|getmetatable|ipairs|load|loadfile|loadstring|module|next|pairs|pcall|print|rawequal|rawget|rawlen|rawset|require|select|self|setmetatable|tointeger|tonumber|tostring|type|unpack|xpcall|activity|call|compile|dump|each|enum|import|loadbitmap|loadlayout|loadmenu|service|set|task|thread|timer|coroutine|debug|io|luajava|math|os|package|string|table|utf8".split("\\|");

    /* renamed from: i */
    private static final char[] f3006i = {'(', ')', '{', '}', ',', ';', '=', '+', '-', '/', '*', '&', '!', '|', ':', '[', ']', '<', '>', '?', '~', '%', '^'};

    private C0417i() {
        super.mo3007a(f3006i);
        super.mo3008a(f3004g);
        super.mo3014b(f3005h);
        super.mo3006a("io", "close|flush|info|input|isdir|lines|ls|mkdir|open|output|popen|read|readall|stderr|stdin|stdout|tmpfile|type|write".split("\\|"));
        super.mo3006a("string", "byte|char|dump|find|format|gfind|gmatch|gsub|len|lower|match|pack|packsize|rep|reverse|sub|unpack|upper".split("\\|"));
        super.mo3006a("luajava", "astable|bindClass|clear|coding|createArray|createProxy|getContext|instanceof|loadLib|loaded|luapath|new|newArray|newInstance|override|package|tostring".split("\\|"));
        super.mo3006a("os", "clock|date|difftime|execute|exit|getenv|remove|rename|setlocale|time|tmpname".split("\\|"));
        super.mo3006a("table", "clear|clone|concat|const|find|foreach|foreachi|gfind|insert|maxn|move|pack|remove|size|sort|unpack".split("\\|"));
        super.mo3006a("math", "abs|acos|asin|atan|atan2|ceil|cos|cosh|deg|exp|floor|fmod|frexp|huge|ldexp|log|log10|max|maxinteger|min|mininteger|modf|pi|pow|rad|random|randomseed|sin|sinh|sqrt|tan|tanh|tointeger|type|ult".split("\\|"));
        super.mo3006a("utf8", "byte|char|charpattern|charpos|codepoint|codes|escape|find|fold|gfind|gmatch|gsub|insert|len|lower|match|ncasecmp|next|offset|remove|reverse|sub|title|upper|width|widthindex".split("\\|"));
        super.mo3006a("coroutine", "create|isyieldable|resume|running|status|wrap|yield".split("\\|"));
        super.mo3006a("package", "config|cpath|loaded|loaders|loadlib|path|preload|searchers|searchpath|seeall".split("\\|"));
        super.mo3006a("debug", "debug|gethook|getinfo|getlocal|getmetatable|getregistry|getupvalue|getuservalue|sethook|setlocal|setmetatable|setupvalue|setuservalue|traceback|upvalueid|upvaluejoin".split("\\|"));
    }

    /* renamed from: g */
    public static C0416h m2650g() {
        if (f3003f == null) {
            f3003f = new C0417i();
        }
        return f3003f;
    }

    /* renamed from: a */
    public boolean mo3010a(char c, char c2) {
        return c == '-' && c2 == '-';
    }

    /* renamed from: b */
    public boolean mo3016b(char c, char c2) {
        return c == '[' && c2 == '[';
    }

    /* renamed from: c */
    public boolean mo3020c(char c, char c2) {
        return c == ']' && c2 == ']';
    }

    /* renamed from: h */
    public boolean mo3033h(char c) {
        return false;
    }
}
