package bsh;

import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

public class Parser implements ParserConstants, ParserTreeConstants {

    /* renamed from: a */
    protected JJTParserState f642a = new JJTParserState();

    /* renamed from: b */
    boolean f643b = false;

    /* renamed from: c */
    JavaCharStream f644c;

    /* renamed from: d */
    private int f645d;

    /* renamed from: e */
    private Token f646e;

    /* renamed from: f */
    private Token f647f;

    /* renamed from: g */
    private int f648g;

    /* renamed from: h */
    private boolean f649h;

    /* renamed from: i */
    private final LookaheadSuccess f650i = new LookaheadSuccess(null);
    public Token jj_nt;
    public boolean lookingAhead = false;
    public Token token;
    public ParserTokenManager token_source;

    /* renamed from: bsh.Parser$1 */
    class C00271 {
    }

    private static final class LookaheadSuccess extends Error {
        private LookaheadSuccess() {
        }

        LookaheadSuccess(C00271 r1) {
            this();
        }
    }

    public Parser(ParserTokenManager parserTokenManager) {
        this.token_source = parserTokenManager;
        this.token = new Token();
        this.f645d = -1;
    }

    public Parser(InputStream inputStream) {
        this.f644c = new JavaCharStream(inputStream, 1, 1);
        this.token_source = new ParserTokenManager(this.f644c);
        this.token = new Token();
        this.f645d = -1;
    }

    public Parser(Reader reader) {
        this.f644c = new JavaCharStream(reader, 1, 1);
        this.token_source = new ParserTokenManager(this.f644c);
        this.token = new Token();
        this.f645d = -1;
    }

    /* renamed from: A */
    private final boolean m404A() {
        if (m653w()) {
            return true;
        }
        Token token2 = this.f646e;
        if (m625i()) {
            this.f646e = token2;
        }
        return false;
    }

    /* renamed from: A */
    private final boolean m405A(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m600da();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: B */
    private final boolean m406B() {
        return m553cH();
    }

    /* renamed from: B */
    private final boolean m407B(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m606dg();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: C */
    private final boolean m408C() {
        return m562cQ() || m417G(78);
    }

    /* renamed from: C */
    private final boolean m409C(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m590cs();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: D */
    private final boolean m410D() {
        return m619f();
    }

    /* renamed from: D */
    private final boolean m411D(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m512bU();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: E */
    private final boolean m412E() {
        return m619f();
    }

    /* renamed from: E */
    private final boolean m413E(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m543bz();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: F */
    private final Token m414F(int i) {
        Token token2 = this.token;
        if (token2.next != null) {
            this.token = this.token.next;
        } else {
            Token token3 = this.token;
            Token nextToken = this.token_source.getNextToken();
            token3.next = nextToken;
            this.token = nextToken;
        }
        this.f645d = -1;
        if (this.token.kind == i) {
            return this.token;
        }
        this.token = token2;
        throw generateParseException();
    }

    /* renamed from: F */
    private final boolean m415F() {
        Token token2 = this.f646e;
        if (m416G()) {
            this.f646e = token2;
            if (m412E()) {
                this.f646e = token2;
                if (m417G(78)) {
                    this.f646e = token2;
                    if (m408C()) {
                        this.f646e = token2;
                        if (m406B()) {
                            this.f646e = token2;
                            if (m659z()) {
                                this.f646e = token2;
                                if (m657y()) {
                                    this.f646e = token2;
                                    if (m655x()) {
                                        this.f646e = token2;
                                        this.lookingAhead = true;
                                        this.f649h = mo982a();
                                        this.lookingAhead = false;
                                        if (!this.f649h || m651v()) {
                                            this.f646e = token2;
                                            if (m647t()) {
                                                this.f646e = token2;
                                                if (m645s()) {
                                                    this.f646e = token2;
                                                    if (m643r()) {
                                                        this.f646e = token2;
                                                        if (m639p()) {
                                                            this.f646e = token2;
                                                            if (m635n()) {
                                                                this.f646e = token2;
                                                                if (m633m()) {
                                                                    this.f646e = token2;
                                                                    if (m631l()) {
                                                                        return true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: G */
    private final boolean m416G() {
        return m623h();
    }

    /* renamed from: G */
    private final boolean m417G(int i) {
        if (this.f646e == this.f647f) {
            this.f648g--;
            if (this.f646e.next == null) {
                Token token2 = this.f646e;
                Token nextToken = this.token_source.getNextToken();
                token2.next = nextToken;
                this.f646e = nextToken;
                this.f647f = nextToken;
            } else {
                Token token3 = this.f646e.next;
                this.f646e = token3;
                this.f647f = token3;
            }
        } else {
            this.f646e = this.f646e.next;
        }
        if (this.f646e.kind != i) {
            return true;
        }
        if (this.f648g != 0 || this.f646e != this.f647f) {
            return false;
        }
        throw this.f650i;
    }

    /* renamed from: H */
    private final boolean m418H() {
        Token token2 = this.f646e;
        if (m417G(81)) {
            this.f646e = token2;
            if (m417G(120)) {
                this.f646e = token2;
                if (m417G(121)) {
                    this.f646e = token2;
                    if (m417G(127)) {
                        this.f646e = token2;
                        if (m417G(118)) {
                            this.f646e = token2;
                            if (m417G(119)) {
                                this.f646e = token2;
                                if (m417G(122)) {
                                    this.f646e = token2;
                                    if (m417G(126)) {
                                        this.f646e = token2;
                                        if (m417G(124)) {
                                            this.f646e = token2;
                                            if (m417G(128)) {
                                                this.f646e = token2;
                                                if (m417G(129)) {
                                                    this.f646e = token2;
                                                    if (m417G(130)) {
                                                        this.f646e = token2;
                                                        if (m417G(131)) {
                                                            this.f646e = token2;
                                                            if (m417G(132)) {
                                                                this.f646e = token2;
                                                                if (m417G(133)) {
                                                                    return true;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: I */
    private final boolean m419I() {
        return m417G(79) || m469af();
    }

    /* renamed from: J */
    private final boolean m420J() {
        return m417G(76) || m417G(77);
    }

    /* renamed from: K */
    private final boolean m421K() {
        if (m468ae()) {
            return true;
        }
        Token token2 = this.f646e;
        if (m410D()) {
            this.f646e = token2;
        }
        return false;
    }

    /* renamed from: L */
    private final boolean m422L() {
        Token token2;
        if (m420J()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m420J());
        this.f646e = token2;
        return m454aQ();
    }

    /* renamed from: M */
    private final boolean m423M() {
        return m574cc() || m418H();
    }

    /* renamed from: N */
    private final boolean m424N() {
        return m417G(76) || m417G(77);
    }

    /* renamed from: O */
    private final boolean m425O() {
        return m429S();
    }

    /* renamed from: P */
    private final boolean m426P() {
        return m417G(76) || m431U() || m417G(77);
    }

    /* renamed from: Q */
    private final boolean m427Q() {
        return m574cc() || m418H() || m431U();
    }

    /* renamed from: R */
    private final boolean m428R() {
        Token token2;
        Token token3;
        if (m426P()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m426P());
        this.f646e = token2;
        do {
            token3 = this.f646e;
        } while (!m424N());
        this.f646e = token3;
        return false;
    }

    /* renamed from: S */
    private final boolean m429S() {
        Token token2 = this.f646e;
        if (m428R()) {
            this.f646e = token2;
            if (m422L()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: T */
    private final boolean m430T() {
        return m404A();
    }

    /* renamed from: U */
    private final boolean m431U() {
        Token token2 = this.f646e;
        if (m432V()) {
            this.f646e = token2;
            if (m430T()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: V */
    private final boolean m432V() {
        return m427Q();
    }

    /* renamed from: W */
    private final boolean m433W() {
        if (m417G(40) || m469af()) {
            return true;
        }
        Token token2 = this.f646e;
        if (m425O()) {
            this.f646e = token2;
            if (m421K()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: X */
    private final boolean m434X() {
        return m417G(40) || m482as() || m429S();
    }

    /* renamed from: Y */
    private final boolean m435Y() {
        Token token2 = this.f646e;
        if (m434X()) {
            this.f646e = token2;
            if (m433W()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: Z */
    private final boolean m436Z() {
        return m417G(79) || m431U();
    }

    /* renamed from: a */
    private final boolean m437a(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m552cG();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: aA */
    private final boolean m438aA() {
        return m482as();
    }

    /* renamed from: aB */
    private final boolean m439aB() {
        return m417G(79) || m449aL();
    }

    /* renamed from: aC */
    private final boolean m440aC() {
        return m417G(67);
    }

    /* renamed from: aD */
    private final boolean m441aD() {
        Token token2;
        Token token3 = this.f646e;
        if (m438aA()) {
            this.f646e = token3;
            if (m478ao()) {
                return true;
            }
        }
        do {
            token2 = this.f646e;
        } while (!m488ay());
        this.f646e = token2;
        return false;
    }

    /* renamed from: aE */
    private final boolean m442aE() {
        return m417G(66);
    }

    /* renamed from: aF */
    private final boolean m443aF() {
        return m417G(28) || m619f();
    }

    /* renamed from: aG */
    private final boolean m444aG() {
        return m417G(79) || m461aX();
    }

    /* renamed from: aH */
    private final boolean m445aH() {
        return m417G(16) || m417G(72) || m449aL() || m417G(73) || m619f();
    }

    /* renamed from: aI */
    private final boolean m446aI() {
        return m417G(69);
    }

    /* renamed from: aJ */
    private final boolean m447aJ() {
        return m441aD() || m417G(69);
    }

    /* renamed from: aK */
    private final boolean m448aK() {
        Token token2;
        if (m449aL()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m439aB());
        this.f646e = token2;
        return false;
    }

    /* renamed from: aL */
    private final boolean m449aL() {
        Token token2 = this.f646e;
        if (m447aJ()) {
            this.f646e = token2;
            if (m446aI()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: aM */
    private final boolean m450aM() {
        Token token2;
        if (m417G(56) || m619f()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m445aH());
        this.f646e = token2;
        Token token3 = this.f646e;
        if (m443aF()) {
            this.f646e = token3;
        }
        return false;
    }

    /* renamed from: aN */
    private final boolean m451aN() {
        if (m417G(72)) {
            return true;
        }
        Token token2 = this.f646e;
        if (m448aK()) {
            this.f646e = token2;
        }
        return m417G(73);
    }

    /* renamed from: aO */
    private final boolean m452aO() {
        Token token2;
        if (m461aX()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m444aG());
        this.f646e = token2;
        return false;
    }

    /* renamed from: aP */
    private final boolean m453aP() {
        return m417G(64);
    }

    /* renamed from: aQ */
    private final boolean m454aQ() {
        if (m417G(74)) {
            return true;
        }
        Token token2 = this.f646e;
        if (m452aO()) {
            this.f646e = token2;
        }
        Token token3 = this.f646e;
        if (m417G(79)) {
            this.f646e = token3;
        }
        return m417G(75);
    }

    /* renamed from: aR */
    private final boolean m455aR() {
        return m417G(80) || m417G(104);
    }

    /* renamed from: aS */
    private final boolean m456aS() {
        return m417G(53) || m431U() || m417G(78);
    }

    /* renamed from: aT */
    private final boolean m457aT() {
        return m417G(81) || m461aX();
    }

    /* renamed from: aU */
    private final boolean m458aU() {
        return m431U();
    }

    /* renamed from: aV */
    private final boolean m459aV() {
        return m431U();
    }

    /* renamed from: aW */
    private final boolean m460aW() {
        return m454aQ();
    }

    /* renamed from: aX */
    private final boolean m461aX() {
        Token token2 = this.f646e;
        if (m460aW()) {
            this.f646e = token2;
            if (m458aU()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: aY */
    private final boolean m462aY() {
        return m417G(51) || m417G(72) || m431U() || m417G(73) || m619f();
    }

    /* renamed from: aZ */
    private final boolean m463aZ() {
        return m417G(79) || m523bf();
    }

    /* renamed from: aa */
    private final boolean m464aa() {
        Token token2;
        if (m469af()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m419I());
        this.f646e = token2;
        return false;
    }

    /* renamed from: ab */
    private final boolean m465ab() {
        Token token2;
        if (m431U()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m436Z());
        this.f646e = token2;
        return false;
    }

    /* renamed from: ac */
    private final boolean m466ac() {
        return m465ab();
    }

    /* renamed from: ad */
    private final boolean m467ad() {
        return m417G(80) || m417G(69);
    }

    /* renamed from: ae */
    private final boolean m468ae() {
        if (m417G(72)) {
            return true;
        }
        Token token2 = this.f646e;
        if (m466ac()) {
            this.f646e = token2;
        }
        return m417G(73);
    }

    /* renamed from: af */
    private final boolean m469af() {
        Token token2;
        if (m417G(69)) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m467ad());
        this.f646e = token2;
        return false;
    }

    /* renamed from: ag */
    private final boolean m470ag() {
        return m417G(22);
    }

    /* renamed from: ah */
    private final boolean m471ah() {
        return m417G(29);
    }

    /* renamed from: ai */
    private final boolean m472ai() {
        return m417G(26);
    }

    /* renamed from: aj */
    private final boolean m473aj() {
        return m417G(38);
    }

    /* renamed from: ak */
    private final boolean m474ak() {
        return m417G(36);
    }

    /* renamed from: al */
    private final boolean m475al() {
        return m417G(55);
    }

    /* renamed from: am */
    private final boolean m476am() {
        Token token2 = this.f646e;
        if (m475al()) {
            this.f646e = token2;
            if (m472ai()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: an */
    private final boolean m477an() {
        return m417G(47);
    }

    /* renamed from: ao */
    private final boolean m478ao() {
        return m469af();
    }

    /* renamed from: ap */
    private final boolean m479ap() {
        return m417G(14);
    }

    /* renamed from: aq */
    private final boolean m480aq() {
        return m417G(17);
    }

    /* renamed from: ar */
    private final boolean m481ar() {
        return m417G(11);
    }

    /* renamed from: as */
    private final boolean m482as() {
        Token token2 = this.f646e;
        if (m481ar()) {
            this.f646e = token2;
            if (m480aq()) {
                this.f646e = token2;
                if (m479ap()) {
                    this.f646e = token2;
                    if (m477an()) {
                        this.f646e = token2;
                        if (m474ak()) {
                            this.f646e = token2;
                            if (m473aj()) {
                                this.f646e = token2;
                                if (m471ah()) {
                                    this.f646e = token2;
                                    if (m470ag()) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: at */
    private final boolean m483at() {
        return m417G(57);
    }

    /* renamed from: au */
    private final boolean m484au() {
        return m441aD();
    }

    /* renamed from: av */
    private final boolean m485av() {
        Token token2 = this.f646e;
        if (m486aw()) {
            this.f646e = token2;
            if (m484au()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: aw */
    private final boolean m486aw() {
        return m417G(57);
    }

    /* renamed from: ax */
    private final boolean m487ax() {
        return m417G(41);
    }

    /* renamed from: ay */
    private final boolean m488ay() {
        return m417G(76) || m417G(77);
    }

    /* renamed from: az */
    private final boolean m489az() {
        return m476am();
    }

    /* renamed from: b */
    private final boolean m490b() {
        return m516bY();
    }

    /* renamed from: b */
    private final boolean m491b(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m537bt();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: bA */
    private final boolean m492bA() {
        return m514bW();
    }

    /* renamed from: bB */
    private final boolean m493bB() {
        return m417G(69);
    }

    /* renamed from: bC */
    private final boolean m494bC() {
        return m485av() || m417G(69);
    }

    /* renamed from: bD */
    private final boolean m495bD() {
        if (m592cu()) {
            return true;
        }
        Token token2 = this.f646e;
        if (m493bB()) {
            this.f646e = token2;
            if (m494bC()) {
                return true;
            }
        }
        if (m451aN()) {
            return true;
        }
        Token token3 = this.f646e;
        if (m541bx()) {
            this.f646e = token3;
        }
        Token token4 = this.f646e;
        if (m538bu()) {
            this.f646e = token4;
            if (m417G(78)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: bE */
    private final boolean m496bE() {
        return m530bm();
    }

    /* renamed from: bF */
    private final boolean m497bF() {
        return m469af();
    }

    /* renamed from: bG */
    private final boolean m498bG() {
        return m534bq();
    }

    /* renamed from: bH */
    private final boolean m499bH() {
        Token token2 = this.f646e;
        if (m498bG()) {
            this.f646e = token2;
            if (m496bE()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: bI */
    private final boolean m500bI() {
        return m441aD();
    }

    /* renamed from: bJ */
    private final boolean m501bJ() {
        return m540bw();
    }

    /* renamed from: bK */
    private final boolean m502bK() {
        return m417G(37);
    }

    /* renamed from: bL */
    private final boolean m503bL() {
        return m514bW();
    }

    /* renamed from: bM */
    private final boolean m504bM() {
        return m435Y();
    }

    /* renamed from: bN */
    private final boolean m505bN() {
        return m417G(72) || m431U() || m417G(73);
    }

    /* renamed from: bO */
    private final boolean m506bO() {
        return m417G(30) || m417G(72) || m441aD() || m417G(69) || m417G(89) || m431U() || m417G(73) || m415F();
    }

    /* renamed from: bP */
    private final boolean m507bP() {
        return m417G(23) || m415F();
    }

    /* renamed from: bQ */
    private final boolean m508bQ() {
        return m417G(33) || m464aa();
    }

    /* renamed from: bR */
    private final boolean m509bR() {
        Token token2 = this.f646e;
        if (m510bS()) {
            this.f646e = token2;
            if (m505bN()) {
                this.f646e = token2;
                if (m504bM()) {
                    this.f646e = token2;
                    if (m503bL()) {
                        this.f646e = token2;
                        if (m500bI()) {
                            this.f646e = token2;
                            if (m497bF()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: bS */
    private final boolean m510bS() {
        return m520bc();
    }

    /* renamed from: bT */
    private final boolean m511bT() {
        return m417G(25) || m469af();
    }

    /* renamed from: bU */
    private final boolean m512bU() {
        return m417G(30) || m417G(72) || m417G(69) || m417G(89) || m431U() || m417G(73) || m415F();
    }

    /* renamed from: bV */
    private final boolean m513bV() {
        Token token2 = this.f646e;
        if (m512bU()) {
            this.f646e = token2;
            if (m506bO()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: bW */
    private final boolean m514bW() {
        return m469af() || m468ae();
    }

    /* renamed from: bX */
    private final boolean m515bX() {
        return m499bH();
    }

    /* renamed from: bY */
    private final boolean m516bY() {
        if (m592cu()) {
            return true;
        }
        Token token2 = this.f646e;
        if (m417G(13)) {
            this.f646e = token2;
            if (m502bK()) {
                return true;
            }
        }
        if (m417G(69)) {
            return true;
        }
        Token token3 = this.f646e;
        if (m511bT()) {
            this.f646e = token3;
        }
        Token token4 = this.f646e;
        if (m508bQ()) {
            this.f646e = token4;
        }
        return m619f();
    }

    /* renamed from: bZ */
    private final boolean m517bZ() {
        return m417G(72) || m482as();
    }

    /* renamed from: ba */
    private final boolean m518ba() {
        return m417G(79) || m562cQ();
    }

    /* renamed from: bb */
    private final boolean m519bb() {
        if (m417G(46)) {
            return true;
        }
        Token token2 = this.f646e;
        if (m459aV()) {
            this.f646e = token2;
        }
        return m417G(78);
    }

    /* renamed from: bc */
    private final boolean m520bc() {
        Token token2 = this.f646e;
        if (m521bd()) {
            this.f646e = token2;
            if (m453aP()) {
                this.f646e = token2;
                if (m442aE()) {
                    this.f646e = token2;
                    if (m440aC()) {
                        this.f646e = token2;
                        if (m489az()) {
                            this.f646e = token2;
                            if (m487ax()) {
                                this.f646e = token2;
                                if (m483at()) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: bd */
    private final boolean m521bd() {
        return m417G(60);
    }

    /* renamed from: be */
    private final boolean m522be() {
        return m468ae();
    }

    /* renamed from: bf */
    private final boolean m523bf() {
        if (m417G(69)) {
            return true;
        }
        Token token2 = this.f646e;
        if (m457aT()) {
            this.f646e = token2;
        }
        return false;
    }

    /* renamed from: bg */
    private final boolean m524bg() {
        return m520bc();
    }

    /* renamed from: bh */
    private final boolean m525bh() {
        if (m417G(19)) {
            return true;
        }
        Token token2 = this.f646e;
        if (m417G(69)) {
            this.f646e = token2;
        }
        return m417G(78);
    }

    /* renamed from: bi */
    private final boolean m526bi() {
        if (m417G(12)) {
            return true;
        }
        Token token2 = this.f646e;
        if (m417G(69)) {
            this.f646e = token2;
        }
        return m417G(78);
    }

    /* renamed from: bj */
    private final boolean m527bj() {
        return m530bm();
    }

    /* renamed from: bk */
    private final boolean m528bk() {
        return m417G(34) || m417G(104) || m417G(78);
    }

    /* renamed from: bl */
    private final boolean m529bl() {
        return m417G(74) || m431U() || m417G(75);
    }

    /* renamed from: bm */
    private final boolean m530bm() {
        Token token2;
        if (m562cQ()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m518ba());
        this.f646e = token2;
        return false;
    }

    /* renamed from: bn */
    private final boolean m531bn() {
        if (m417G(80) || m417G(69)) {
            return true;
        }
        Token token2 = this.f646e;
        if (m522be()) {
            this.f646e = token2;
        }
        return false;
    }

    /* renamed from: bo */
    private final boolean m532bo() {
        Token token2 = this.f646e;
        if (m417G(48)) {
            this.f646e = token2;
        }
        if (m417G(34) || m469af()) {
            return true;
        }
        Token token3 = this.f646e;
        if (m455aR()) {
            this.f646e = token3;
        }
        return m417G(78);
    }

    /* renamed from: bp */
    private final boolean m533bp() {
        Token token2 = this.f646e;
        if (m532bo()) {
            this.f646e = token2;
            if (m528bk()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: bq */
    private final boolean m534bq() {
        Token token2;
        if (m592cu() || m441aD() || m523bf()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m463aZ());
        this.f646e = token2;
        return false;
    }

    /* renamed from: br */
    private final boolean m535br() {
        return m417G(76) || m431U() || m417G(77);
    }

    /* renamed from: bs */
    private final boolean m536bs() {
        return m417G(42) || m469af();
    }

    /* renamed from: bt */
    private final boolean m537bt() {
        return m417G(69) || m417G(72);
    }

    /* renamed from: bu */
    private final boolean m538bu() {
        return m619f();
    }

    /* renamed from: bv */
    private final boolean m539bv() {
        return m417G(80) || m417G(13);
    }

    /* renamed from: bw */
    private final boolean m540bw() {
        Token token2 = this.f646e;
        if (m539bv()) {
            this.f646e = token2;
            if (m535br()) {
                this.f646e = token2;
                if (m531bn()) {
                    this.f646e = token2;
                    if (m529bl()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: bx */
    private final boolean m541bx() {
        return m417G(54) || m464aa();
    }

    /* renamed from: by */
    private final boolean m542by() {
        return m441aD() || m417G(80) || m417G(13);
    }

    /* renamed from: bz */
    private final boolean m543bz() {
        return m592cu() || m441aD() || m417G(69);
    }

    /* renamed from: c */
    private final boolean m544c() {
        Token token2 = this.f646e;
        if (m490b()) {
            this.f646e = token2;
            if (m614do()) {
                this.f646e = token2;
                if (m612dm()) {
                    this.f646e = token2;
                    if (m609dj()) {
                        this.f646e = token2;
                        if (m606dg()) {
                            this.f646e = token2;
                            if (m603dd()) {
                                this.f646e = token2;
                                if (m601db()) {
                                    this.f646e = token2;
                                    if (m570cY()) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    private final boolean m545c(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m532bo();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: cA */
    private final boolean m546cA() {
        Token token2 = this.f646e;
        if (m417G(87)) {
            this.f646e = token2;
            if (m417G(86)) {
                return true;
            }
        }
        return m560cO();
    }

    /* renamed from: cB */
    private final boolean m547cB() {
        Token token2 = this.f646e;
        if (m546cA()) {
            this.f646e = token2;
            if (m596cy()) {
                this.f646e = token2;
                if (m595cx()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: cC */
    private final boolean m548cC() {
        return m417G(15) || m431U() || m417G(89);
    }

    /* renamed from: cD */
    private final boolean m549cD() {
        Token token2 = this.f646e;
        if (m548cC()) {
            this.f646e = token2;
            if (m597cz()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: cE */
    private final boolean m550cE() {
        Token token2;
        if (m549cD()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m590cs());
        this.f646e = token2;
        return false;
    }

    /* renamed from: cF */
    private final boolean m551cF() {
        return m417G(101) || m574cc();
    }

    /* renamed from: cG */
    private final boolean m552cG() {
        return m544c();
    }

    /* renamed from: cH */
    private final boolean m553cH() {
        Token token2;
        if (m417G(50) || m417G(72) || m431U() || m417G(73) || m417G(74)) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m550cE());
        this.f646e = token2;
        return m417G(75);
    }

    /* renamed from: cI */
    private final boolean m554cI() {
        Token token2 = this.f646e;
        if (m417G(104)) {
            this.f646e = token2;
            if (m417G(105)) {
                this.f646e = token2;
                if (m417G(111)) {
                    return true;
                }
            }
        }
        return m560cO();
    }

    /* renamed from: cJ */
    private final boolean m555cJ() {
        return m417G(100) || m574cc();
    }

    /* renamed from: cK */
    private final boolean m556cK() {
        return m547cB();
    }

    /* renamed from: cL */
    private final boolean m557cL() {
        return m551cF();
    }

    /* renamed from: cM */
    private final boolean m558cM() {
        return m555cJ();
    }

    /* renamed from: cN */
    private final boolean m559cN() {
        Token token2 = this.f646e;
        if (m417G(102)) {
            this.f646e = token2;
            if (m417G(103)) {
                return true;
            }
        }
        return m560cO();
    }

    /* renamed from: cO */
    private final boolean m560cO() {
        Token token2 = this.f646e;
        if (m559cN()) {
            this.f646e = token2;
            if (m558cM()) {
                this.f646e = token2;
                if (m557cL()) {
                    this.f646e = token2;
                    if (m556cK()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: cP */
    private final boolean m561cP() {
        return m417G(54) || m464aa();
    }

    /* renamed from: cQ */
    private final boolean m562cQ() {
        return m431U();
    }

    /* renamed from: cR */
    private final boolean m563cR() {
        Token token2;
        if (m560cO()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m554cI());
        this.f646e = token2;
        return false;
    }

    /* renamed from: cS */
    private final boolean m564cS() {
        Token token2 = this.f646e;
        if (m417G(102)) {
            this.f646e = token2;
            if (m417G(103)) {
                return true;
            }
        }
        return m563cR();
    }

    /* renamed from: cT */
    private final boolean m565cT() {
        Token token2;
        if (m563cR()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m564cS());
        this.f646e = token2;
        return false;
    }

    /* renamed from: cU */
    private final boolean m566cU() {
        return m417G(68);
    }

    /* renamed from: cV */
    private final boolean m567cV() {
        Token token2 = this.f646e;
        if (m417G(112)) {
            this.f646e = token2;
            if (m417G(113)) {
                this.f646e = token2;
                if (m417G(114)) {
                    this.f646e = token2;
                    if (m417G(115)) {
                        this.f646e = token2;
                        if (m417G(116)) {
                            this.f646e = token2;
                            if (m417G(117)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return m565cT();
    }

    /* renamed from: cW */
    private final boolean m568cW() {
        Token token2 = this.f646e;
        if (m417G(90)) {
            this.f646e = token2;
            if (m417G(95)) {
                return true;
            }
        }
        return m607dh();
    }

    /* renamed from: cX */
    private final boolean m569cX() {
        Token token2;
        if (m565cT()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m567cV());
        this.f646e = token2;
        return false;
    }

    /* renamed from: cY */
    private final boolean m570cY() {
        return m566cU();
    }

    /* renamed from: cZ */
    private final boolean m571cZ() {
        Token token2 = this.f646e;
        if (m417G(84)) {
            this.f646e = token2;
            if (m417G(85)) {
                this.f646e = token2;
                if (m417G(82)) {
                    this.f646e = token2;
                    if (m417G(83)) {
                        this.f646e = token2;
                        if (m417G(91)) {
                            this.f646e = token2;
                            if (m417G(92)) {
                                this.f646e = token2;
                                if (m417G(93)) {
                                    this.f646e = token2;
                                    if (m417G(94)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return m569cX();
    }

    /* renamed from: ca */
    private final boolean m572ca() {
        return m527bj();
    }

    /* renamed from: cb */
    private final boolean m573cb() {
        return m431U();
    }

    /* renamed from: cc */
    private final boolean m574cc() {
        Token token2;
        if (m509bR()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m501bJ());
        this.f646e = token2;
        return false;
    }

    /* renamed from: cd */
    private final boolean m575cd() {
        return m417G(72) || m441aD() || m417G(73) || m547cB();
    }

    /* renamed from: ce */
    private final boolean m576ce() {
        return m417G(72) || m441aD() || m417G(73) || m560cO();
    }

    /* renamed from: cf */
    private final boolean m577cf() {
        if (m417G(30) || m417G(72)) {
            return true;
        }
        Token token2 = this.f646e;
        if (m515bX()) {
            this.f646e = token2;
        }
        if (m417G(78)) {
            return true;
        }
        Token token3 = this.f646e;
        if (m573cb()) {
            this.f646e = token3;
        }
        if (m417G(78)) {
            return true;
        }
        Token token4 = this.f646e;
        if (m572ca()) {
            this.f646e = token4;
        }
        return m417G(73) || m415F();
    }

    /* renamed from: cg */
    private final boolean m578cg() {
        Token token2 = this.f646e;
        if (m576ce()) {
            this.f646e = token2;
            if (m575cd()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ch */
    private final boolean m579ch() {
        if (m574cc()) {
            return true;
        }
        Token token2 = this.f646e;
        if (m417G(100)) {
            this.f646e = token2;
            if (m417G(101)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ci */
    private final boolean m580ci() {
        return m574cc();
    }

    /* renamed from: cj */
    private final boolean m581cj() {
        return m417G(21) || m415F() || m417G(59) || m417G(72) || m431U() || m417G(73) || m417G(78);
    }

    /* renamed from: ck */
    private final boolean m582ck() {
        return m417G(72) || m469af() || m417G(76);
    }

    /* renamed from: cl */
    private final boolean m583cl() {
        if (m574cc()) {
            return true;
        }
        Token token2 = this.f646e;
        if (m417G(100)) {
            this.f646e = token2;
            if (m417G(101)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: cm */
    private final boolean m584cm() {
        Token token2 = this.f646e;
        if (m583cl()) {
            this.f646e = token2;
            if (m580ci()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: cn */
    private final boolean m585cn() {
        Token token2 = this.f646e;
        if (m417G(43)) {
            this.f646e = token2;
            if (m417G(44)) {
                this.f646e = token2;
                if (m417G(45)) {
                    this.f646e = token2;
                    if (m417G(51)) {
                        this.f646e = token2;
                        if (m417G(27)) {
                            this.f646e = token2;
                            if (m417G(39)) {
                                this.f646e = token2;
                                if (m417G(52)) {
                                    this.f646e = token2;
                                    if (m417G(58)) {
                                        this.f646e = token2;
                                        if (m417G(10)) {
                                            this.f646e = token2;
                                            if (m417G(48)) {
                                                this.f646e = token2;
                                                if (m417G(49)) {
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: co */
    private final boolean m586co() {
        return m417G(59) || m417G(72) || m431U() || m417G(73) || m415F();
    }

    /* renamed from: cp */
    private final boolean m587cp() {
        if (m417G(72) || m469af() || m417G(73)) {
            return true;
        }
        Token token2 = this.f646e;
        if (m417G(87)) {
            this.f646e = token2;
            if (m417G(86)) {
                this.f646e = token2;
                if (m417G(72)) {
                    this.f646e = token2;
                    if (m417G(69)) {
                        this.f646e = token2;
                        if (m417G(40)) {
                            this.f646e = token2;
                            if (m524bg()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: cq */
    private final boolean m588cq() {
        return m417G(72) || m469af() || m417G(76) || m417G(77);
    }

    /* renamed from: cr */
    private final boolean m589cr() {
        return m593cv();
    }

    /* renamed from: cs */
    private final boolean m590cs() {
        return m544c();
    }

    /* renamed from: ct */
    private final boolean m591ct() {
        if (m417G(32) || m417G(72) || m431U() || m417G(73) || m415F()) {
            return true;
        }
        Token token2 = this.f646e;
        if (m507bP()) {
            this.f646e = token2;
        }
        return false;
    }

    /* renamed from: cu */
    private final boolean m592cu() {
        Token token2;
        do {
            token2 = this.f646e;
        } while (!m585cn());
        this.f646e = token2;
        return false;
    }

    /* renamed from: cv */
    private final boolean m593cv() {
        Token token2 = this.f646e;
        if (m594cw()) {
            this.f646e = token2;
            if (m588cq()) {
                this.f646e = token2;
                if (m587cp()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: cw */
    private final boolean m594cw() {
        return m417G(72) || m482as();
    }

    /* renamed from: cx */
    private final boolean m595cx() {
        return m584cm();
    }

    /* renamed from: cy */
    private final boolean m596cy() {
        return m578cg();
    }

    /* renamed from: cz */
    private final boolean m597cz() {
        return m417G(20) || m417G(89);
    }

    /* renamed from: d */
    private final boolean m598d() {
        return m544c();
    }

    /* renamed from: d */
    private final boolean m599d(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m444aG();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: da */
    private final boolean m600da() {
        return m592cu() || m441aD() || m417G(69);
    }

    /* renamed from: db */
    private final boolean m601db() {
        return m536bs();
    }

    /* renamed from: dc */
    private final boolean m602dc() {
        Token token2;
        if (m569cX()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m571cZ());
        this.f646e = token2;
        return false;
    }

    /* renamed from: dd */
    private final boolean m603dd() {
        return m533bp();
    }

    /* renamed from: de */
    private final boolean m604de() {
        if (m592cu() || m417G(69) || m451aN()) {
            return true;
        }
        Token token2 = this.f646e;
        if (m561cP()) {
            this.f646e = token2;
        }
        return m417G(74);
    }

    /* renamed from: df */
    private final boolean m605df() {
        return m417G(35) || m441aD();
    }

    /* renamed from: dg */
    private final boolean m606dg() {
        return m415F();
    }

    /* renamed from: dh */
    private final boolean m607dh() {
        if (m602dc()) {
            return true;
        }
        Token token2 = this.f646e;
        if (m605df()) {
            this.f646e = token2;
        }
        return false;
    }

    /* renamed from: di */
    private final boolean m608di() {
        return m592cu() || m485av() || m417G(69) || m417G(72);
    }

    /* renamed from: dj */
    private final boolean m609dj() {
        return m534bq() || m417G(78);
    }

    /* renamed from: dk */
    private final boolean m610dk() {
        if (m592cu()) {
            return true;
        }
        Token token2 = this.f646e;
        if (m417G(13)) {
            this.f646e = token2;
            if (m417G(37)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: dl */
    private final boolean m611dl() {
        return m417G(110) || m617e();
    }

    /* renamed from: dm */
    private final boolean m612dm() {
        return m495bD();
    }

    /* renamed from: dn */
    private final boolean m613dn() {
        Token token2;
        if (m607dh()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m568cW());
        this.f646e = token2;
        return false;
    }

    /* renamed from: do */
    private final boolean m614do() {
        return m495bD();
    }

    /* renamed from: dp */
    private final boolean m615dp() {
        Token token2 = this.f646e;
        if (m417G(106)) {
            this.f646e = token2;
            if (m417G(107)) {
                return true;
            }
        }
        return m613dn();
    }

    /* renamed from: dq */
    private final int m616dq() {
        int i;
        Token token2 = this.token.next;
        this.jj_nt = token2;
        if (token2 == null) {
            Token token3 = this.token;
            Token nextToken = this.token_source.getNextToken();
            token3.next = nextToken;
            i = nextToken.kind;
        } else {
            i = this.jj_nt.kind;
        }
        this.f645d = i;
        return i;
    }

    /* renamed from: e */
    private final boolean m617e() {
        Token token2;
        if (m613dn()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m615dp());
        this.f646e = token2;
        return false;
    }

    /* renamed from: e */
    private final boolean m618e(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m447aJ();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: f */
    private final boolean m619f() {
        Token token2;
        if (m417G(74)) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m598d());
        this.f646e = token2;
        return m417G(75);
    }

    /* renamed from: f */
    private final boolean m620f(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m488ay();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: g */
    private final boolean m621g() {
        Token token2;
        if (m617e()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m611dl());
        this.f646e = token2;
        return false;
    }

    /* renamed from: g */
    private final boolean m622g(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m467ad();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: h */
    private final boolean m623h() {
        return m417G(69) || m417G(89) || m415F();
    }

    /* renamed from: h */
    private final boolean m624h(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m423M();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: i */
    private final boolean m625i() {
        return m417G(88) || m431U() || m417G(89) || m404A();
    }

    /* renamed from: i */
    private final boolean m626i(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m589cr();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: j */
    private final boolean m627j() {
        Token token2 = this.f646e;
        if (m417G(108)) {
            this.f646e = token2;
            if (m417G(109)) {
                return true;
            }
        }
        return m621g();
    }

    /* renamed from: j */
    private final boolean m628j(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m594cw();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: k */
    private final boolean m629k() {
        Token token2;
        if (m621g()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m627j());
        this.f646e = token2;
        return false;
    }

    /* renamed from: k */
    private final boolean m630k(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m582ck();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: l */
    private final boolean m631l() {
        return m450aM();
    }

    /* renamed from: l */
    private final boolean m632l(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m579ch();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: m */
    private final boolean m633m() {
        return m456aS();
    }

    /* renamed from: m */
    private final boolean m634m(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m517bZ();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    public static void main(String[] strArr) {
        boolean z;
        int i = 0;
        if (strArr[0].equals("-p")) {
            i = 1;
            z = true;
        } else {
            z = false;
        }
        while (i < strArr.length) {
            Parser parser = new Parser((Reader) new FileReader(strArr[i]));
            parser.setRetainComments(true);
            while (!parser.Line()) {
                if (z) {
                    System.out.println(parser.popNode());
                }
            }
            i++;
        }
    }

    /* renamed from: n */
    private final boolean m635n() {
        return m462aY();
    }

    /* renamed from: n */
    private final boolean m636n(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m492bA();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: o */
    private final boolean m637o() {
        Token token2 = this.f646e;
        if (m417G(98)) {
            this.f646e = token2;
            if (m417G(99)) {
                return true;
            }
        }
        return m629k();
    }

    /* renamed from: o */
    private final boolean m638o(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m542by();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: p */
    private final boolean m639p() {
        return m519bb();
    }

    /* renamed from: p */
    private final boolean m640p(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m539bv();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: q */
    private final boolean m641q() {
        Token token2;
        if (m629k()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m637o());
        this.f646e = token2;
        return false;
    }

    /* renamed from: q */
    private final boolean m642q(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m410D();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: r */
    private final boolean m643r() {
        return m525bh();
    }

    /* renamed from: r */
    private final boolean m644r(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m434X();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: s */
    private final boolean m645s() {
        return m526bi();
    }

    /* renamed from: s */
    private final boolean m646s(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m426P();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: t */
    private final boolean m647t() {
        return m513bV();
    }

    /* renamed from: t */
    private final boolean m648t(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m424N();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: u */
    private final boolean m649u() {
        Token token2 = this.f646e;
        if (m417G(96)) {
            this.f646e = token2;
            if (m417G(97)) {
                return true;
            }
        }
        return m641q();
    }

    /* renamed from: u */
    private final boolean m650u(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m428R();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: v */
    private final boolean m651v() {
        return m577cf();
    }

    /* renamed from: v */
    private final boolean m652v(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m416G();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: w */
    private final boolean m653w() {
        Token token2;
        if (m641q()) {
            return true;
        }
        do {
            token2 = this.f646e;
        } while (!m649u());
        this.f646e = token2;
        return false;
    }

    /* renamed from: w */
    private final boolean m654w(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m598d();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: x */
    private final boolean m655x() {
        return m581cj();
    }

    /* renamed from: x */
    private final boolean m656x(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m610dk();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: y */
    private final boolean m657y() {
        return m586co();
    }

    /* renamed from: y */
    private final boolean m658y(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m608di();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    /* renamed from: z */
    private final boolean m659z() {
        return m591ct();
    }

    /* renamed from: z */
    private final boolean m660z(int i) {
        this.f648g = i;
        Token token2 = this.token;
        this.f646e = token2;
        this.f647f = token2;
        try {
            return true ^ m604de();
        } catch (LookaheadSuccess unused) {
            return true;
        }
    }

    public final void AdditiveExpression() {
        int i;
        MultiplicativeExpression();
        while (true) {
            switch (this.f645d == -1 ? m616dq() : this.f645d) {
                case 102:
                case 103:
                    switch (this.f645d == -1 ? m616dq() : this.f645d) {
                        case 102:
                            i = 102;
                            break;
                        case 103:
                            i = 103;
                            break;
                        default:
                            m414F(-1);
                            throw new ParseException();
                    }
                    Token F = m414F(i);
                    MultiplicativeExpression();
                    BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(15);
                    boolean z = true;
                    this.f642a.mo808c(bSHBinaryExpression);
                    mo980a((Node) bSHBinaryExpression);
                    try {
                        this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                        z = false;
                        mo983b((Node) bSHBinaryExpression);
                        bSHBinaryExpression.kind = F.kind;
                    } catch (Throwable th) {
                        if (z) {
                            this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                            mo983b((Node) bSHBinaryExpression);
                        }
                        throw th;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void AllocationExpression() {
        /*
            r6 = this;
            bsh.BSHAllocationExpression r0 = new bsh.BSHAllocationExpression
            r1 = 23
            r0.<init>(r1)
            bsh.JJTParserState r1 = r6.f642a
            r1.mo808c(r0)
            r6.mo980a(r0)
            r1 = 2
            r2 = 1
            boolean r3 = r6.m644r(r1)     // Catch:{ Throwable -> 0x0074 }
            r4 = 40
            if (r3 == 0) goto L_0x0023
            r6.m414F(r4)     // Catch:{ Throwable -> 0x0074 }
            r6.PrimitiveType()     // Catch:{ Throwable -> 0x0074 }
        L_0x001f:
            r6.ArrayDimensions()     // Catch:{ Throwable -> 0x0074 }
            goto L_0x0068
        L_0x0023:
            int r3 = r6.f645d     // Catch:{ Throwable -> 0x0074 }
            r5 = -1
            if (r3 != r5) goto L_0x002d
            int r3 = r6.m616dq()     // Catch:{ Throwable -> 0x0074 }
            goto L_0x002f
        L_0x002d:
            int r3 = r6.f645d     // Catch:{ Throwable -> 0x0074 }
        L_0x002f:
            if (r3 == r4) goto L_0x003a
            r6.m414F(r5)     // Catch:{ Throwable -> 0x0074 }
            bsh.ParseException r1 = new bsh.ParseException     // Catch:{ Throwable -> 0x0074 }
            r1.<init>()     // Catch:{ Throwable -> 0x0074 }
            throw r1     // Catch:{ Throwable -> 0x0074 }
        L_0x003a:
            r6.m414F(r4)     // Catch:{ Throwable -> 0x0074 }
            r6.AmbiguousName()     // Catch:{ Throwable -> 0x0074 }
            int r3 = r6.f645d     // Catch:{ Throwable -> 0x0074 }
            if (r3 != r5) goto L_0x0049
            int r3 = r6.m616dq()     // Catch:{ Throwable -> 0x0074 }
            goto L_0x004b
        L_0x0049:
            int r3 = r6.f645d     // Catch:{ Throwable -> 0x0074 }
        L_0x004b:
            r4 = 72
            if (r3 == r4) goto L_0x005c
            r1 = 76
            if (r3 == r1) goto L_0x001f
            r6.m414F(r5)     // Catch:{ Throwable -> 0x0074 }
            bsh.ParseException r1 = new bsh.ParseException     // Catch:{ Throwable -> 0x0074 }
            r1.<init>()     // Catch:{ Throwable -> 0x0074 }
            throw r1     // Catch:{ Throwable -> 0x0074 }
        L_0x005c:
            r6.Arguments()     // Catch:{ Throwable -> 0x0074 }
            boolean r1 = r6.m642q(r1)     // Catch:{ Throwable -> 0x0074 }
            if (r1 == 0) goto L_0x0068
            r6.Block()     // Catch:{ Throwable -> 0x0074 }
        L_0x0068:
            bsh.JJTParserState r1 = r6.f642a
            r1.mo804a(r0, r2)
            r6.mo983b(r0)
            return
        L_0x0071:
            r1 = move-exception
            r3 = 1
            goto L_0x008d
        L_0x0074:
            r1 = move-exception
            bsh.JJTParserState r3 = r6.f642a     // Catch:{ all -> 0x0071 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0071 }
            r3 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x008c }
            if (r4 == 0) goto L_0x0082
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x008c }
            throw r1     // Catch:{ all -> 0x008c }
        L_0x0082:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x008c }
            if (r4 == 0) goto L_0x0089
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x008c }
            throw r1     // Catch:{ all -> 0x008c }
        L_0x0089:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x008c }
            throw r1     // Catch:{ all -> 0x008c }
        L_0x008c:
            r1 = move-exception
        L_0x008d:
            if (r3 == 0) goto L_0x0097
            bsh.JJTParserState r3 = r6.f642a
            r3.mo804a(r0, r2)
            r6.mo983b(r0)
        L_0x0097:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.AllocationExpression():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void AmbiguousName() {
        /*
            r7 = this;
            bsh.BSHAmbiguousName r0 = new bsh.BSHAmbiguousName
            r1 = 12
            r0.<init>(r1)
            bsh.JJTParserState r1 = r7.f642a
            r1.mo808c(r0)
            r7.mo980a(r0)
            r1 = 69
            r2 = 1
            bsh.Token r3 = r7.m414F(r1)     // Catch:{ all -> 0x0058 }
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ all -> 0x0058 }
            java.lang.String r3 = r3.image     // Catch:{ all -> 0x0058 }
            r4.<init>(r3)     // Catch:{ all -> 0x0058 }
        L_0x001d:
            r3 = 2
            boolean r3 = r7.m622g(r3)     // Catch:{ all -> 0x0058 }
            if (r3 == 0) goto L_0x0044
            r3 = 80
            r7.m414F(r3)     // Catch:{ all -> 0x0058 }
            bsh.Token r3 = r7.m414F(r1)     // Catch:{ all -> 0x0058 }
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ all -> 0x0058 }
            r5.<init>()     // Catch:{ all -> 0x0058 }
            java.lang.String r6 = "."
            r5.append(r6)     // Catch:{ all -> 0x0058 }
            java.lang.String r3 = r3.image     // Catch:{ all -> 0x0058 }
            r5.append(r3)     // Catch:{ all -> 0x0058 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0058 }
            r4.append(r3)     // Catch:{ all -> 0x0058 }
            goto L_0x001d
        L_0x0044:
            bsh.JJTParserState r1 = r7.f642a     // Catch:{ all -> 0x0058 }
            r1.mo804a(r0, r2)     // Catch:{ all -> 0x0058 }
            r1 = 0
            r7.mo983b(r0)     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0054 }
            r0.text = r3     // Catch:{ all -> 0x0054 }
            return
        L_0x0054:
            r3 = move-exception
            r1 = r3
            r3 = 0
            goto L_0x005a
        L_0x0058:
            r1 = move-exception
            r3 = 1
        L_0x005a:
            if (r3 == 0) goto L_0x0064
            bsh.JJTParserState r3 = r7.f642a
            r3.mo804a(r0, r2)
            r7.mo983b(r0)
        L_0x0064:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.AmbiguousName():void");
    }

    public final void AndExpression() {
        int i;
        EqualityExpression();
        while (true) {
            switch (this.f645d == -1 ? m616dq() : this.f645d) {
                case 106:
                case 107:
                    switch (this.f645d == -1 ? m616dq() : this.f645d) {
                        case 106:
                            i = 106;
                            break;
                        case 107:
                            i = 107;
                            break;
                        default:
                            m414F(-1);
                            throw new ParseException();
                    }
                    Token F = m414F(i);
                    EqualityExpression();
                    BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(15);
                    boolean z = true;
                    this.f642a.mo808c(bSHBinaryExpression);
                    mo980a((Node) bSHBinaryExpression);
                    try {
                        this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                        z = false;
                        mo983b((Node) bSHBinaryExpression);
                        bSHBinaryExpression.kind = F.kind;
                    } catch (Throwable th) {
                        if (z) {
                            this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                            mo983b((Node) bSHBinaryExpression);
                        }
                        throw th;
                    }
                default:
                    return;
            }
        }
    }

    public final void ArgumentList() {
        while (true) {
            Expression();
            if ((this.f645d == -1 ? m616dq() : this.f645d) == 79) {
                m414F(79);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Arguments() {
        /*
            r5 = this;
            bsh.BSHArguments r0 = new bsh.BSHArguments
            r1 = 22
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 72
            r2 = 1
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0039 }
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0039 }
            r3 = -1
            if (r1 != r3) goto L_0x001f
            int r1 = r5.m616dq()     // Catch:{ Throwable -> 0x0039 }
            goto L_0x0021
        L_0x001f:
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0039 }
        L_0x0021:
            switch(r1) {
                case 11: goto L_0x0025;
                case 14: goto L_0x0025;
                case 17: goto L_0x0025;
                case 22: goto L_0x0025;
                case 26: goto L_0x0025;
                case 29: goto L_0x0025;
                case 36: goto L_0x0025;
                case 38: goto L_0x0025;
                case 40: goto L_0x0025;
                case 41: goto L_0x0025;
                case 47: goto L_0x0025;
                case 55: goto L_0x0025;
                case 57: goto L_0x0025;
                case 60: goto L_0x0025;
                case 64: goto L_0x0025;
                case 66: goto L_0x0025;
                case 67: goto L_0x0025;
                case 69: goto L_0x0025;
                case 72: goto L_0x0025;
                case 86: goto L_0x0025;
                case 87: goto L_0x0025;
                case 100: goto L_0x0025;
                case 101: goto L_0x0025;
                case 102: goto L_0x0025;
                case 103: goto L_0x0025;
                default: goto L_0x0024;
            }     // Catch:{ Throwable -> 0x0039 }
        L_0x0024:
            goto L_0x0028
        L_0x0025:
            r5.ArgumentList()     // Catch:{ Throwable -> 0x0039 }
        L_0x0028:
            r1 = 73
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0039 }
            bsh.JJTParserState r1 = r5.f642a
            r1.mo804a(r0, r2)
            r5.mo983b(r0)
            return
        L_0x0036:
            r1 = move-exception
            r3 = 1
            goto L_0x0052
        L_0x0039:
            r1 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x0036 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0036 }
            r3 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0051 }
            if (r4 == 0) goto L_0x0047
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x0051 }
            throw r1     // Catch:{ all -> 0x0051 }
        L_0x0047:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x0051 }
            if (r4 == 0) goto L_0x004e
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x0051 }
            throw r1     // Catch:{ all -> 0x0051 }
        L_0x004e:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x0051 }
            throw r1     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r1 = move-exception
        L_0x0052:
            if (r3 == 0) goto L_0x005c
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r2)
            r5.mo983b(r0)
        L_0x005c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.Arguments():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ArrayDimensions() {
        /*
            r6 = this;
            bsh.BSHArrayDimensions r0 = new bsh.BSHArrayDimensions
            r1 = 24
            r0.<init>(r1)
            bsh.JJTParserState r1 = r6.f642a
            r1.mo808c(r0)
            r6.mo980a(r0)
            r1 = 2
            r2 = 1
            boolean r3 = r6.m650u(r1)     // Catch:{ Throwable -> 0x007a }
            r4 = 77
            r5 = 76
            if (r3 == 0) goto L_0x003e
        L_0x001b:
            r6.m414F(r5)     // Catch:{ Throwable -> 0x007a }
            r6.Expression()     // Catch:{ Throwable -> 0x007a }
            r6.m414F(r4)     // Catch:{ Throwable -> 0x007a }
            r0.addDefinedDimension()     // Catch:{ Throwable -> 0x007a }
            boolean r3 = r6.m646s(r1)     // Catch:{ Throwable -> 0x007a }
            if (r3 == 0) goto L_0x002e
            goto L_0x001b
        L_0x002e:
            boolean r3 = r6.m648t(r1)     // Catch:{ Throwable -> 0x007a }
            if (r3 == 0) goto L_0x006e
            r6.m414F(r5)     // Catch:{ Throwable -> 0x007a }
            r6.m414F(r4)     // Catch:{ Throwable -> 0x007a }
            r0.addUndefinedDimension()     // Catch:{ Throwable -> 0x007a }
            goto L_0x002e
        L_0x003e:
            int r1 = r6.f645d     // Catch:{ Throwable -> 0x007a }
            r3 = -1
            if (r1 != r3) goto L_0x0048
            int r1 = r6.m616dq()     // Catch:{ Throwable -> 0x007a }
            goto L_0x004a
        L_0x0048:
            int r1 = r6.f645d     // Catch:{ Throwable -> 0x007a }
        L_0x004a:
            if (r1 == r5) goto L_0x0055
            r6.m414F(r3)     // Catch:{ Throwable -> 0x007a }
            bsh.ParseException r1 = new bsh.ParseException     // Catch:{ Throwable -> 0x007a }
            r1.<init>()     // Catch:{ Throwable -> 0x007a }
            throw r1     // Catch:{ Throwable -> 0x007a }
        L_0x0055:
            r6.m414F(r5)     // Catch:{ Throwable -> 0x007a }
            r6.m414F(r4)     // Catch:{ Throwable -> 0x007a }
            r0.addUndefinedDimension()     // Catch:{ Throwable -> 0x007a }
            int r1 = r6.f645d     // Catch:{ Throwable -> 0x007a }
            if (r1 != r3) goto L_0x0067
            int r1 = r6.m616dq()     // Catch:{ Throwable -> 0x007a }
            goto L_0x0069
        L_0x0067:
            int r1 = r6.f645d     // Catch:{ Throwable -> 0x007a }
        L_0x0069:
            if (r1 == r5) goto L_0x0055
            r6.ArrayInitializer()     // Catch:{ Throwable -> 0x007a }
        L_0x006e:
            bsh.JJTParserState r1 = r6.f642a
            r1.mo804a(r0, r2)
            r6.mo983b(r0)
            return
        L_0x0077:
            r1 = move-exception
            r3 = 1
            goto L_0x0093
        L_0x007a:
            r1 = move-exception
            bsh.JJTParserState r3 = r6.f642a     // Catch:{ all -> 0x0077 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0077 }
            r3 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0092 }
            if (r4 == 0) goto L_0x0088
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x0092 }
            throw r1     // Catch:{ all -> 0x0092 }
        L_0x0088:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x0092 }
            if (r4 == 0) goto L_0x008f
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x0092 }
            throw r1     // Catch:{ all -> 0x0092 }
        L_0x008f:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x0092 }
            throw r1     // Catch:{ all -> 0x0092 }
        L_0x0092:
            r1 = move-exception
        L_0x0093:
            if (r3 == 0) goto L_0x009d
            bsh.JJTParserState r3 = r6.f642a
            r3.mo804a(r0, r2)
            r6.mo983b(r0)
        L_0x009d:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.ArrayDimensions():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (m599d(2) == false) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ArrayInitializer() {
        /*
            r5 = this;
            bsh.BSHArrayInitializer r0 = new bsh.BSHArrayInitializer
            r1 = 6
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 74
            r2 = 1
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0056 }
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0056 }
            r3 = -1
            if (r1 != r3) goto L_0x001e
            int r1 = r5.m616dq()     // Catch:{ Throwable -> 0x0056 }
            goto L_0x0020
        L_0x001e:
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0056 }
        L_0x0020:
            r4 = 79
            switch(r1) {
                case 11: goto L_0x0026;
                case 14: goto L_0x0026;
                case 17: goto L_0x0026;
                case 22: goto L_0x0026;
                case 26: goto L_0x0026;
                case 29: goto L_0x0026;
                case 36: goto L_0x0026;
                case 38: goto L_0x0026;
                case 40: goto L_0x0026;
                case 41: goto L_0x0026;
                case 47: goto L_0x0026;
                case 55: goto L_0x0026;
                case 57: goto L_0x0026;
                case 60: goto L_0x0026;
                case 64: goto L_0x0026;
                case 66: goto L_0x0026;
                case 67: goto L_0x0026;
                case 69: goto L_0x0026;
                case 72: goto L_0x0026;
                case 74: goto L_0x0026;
                case 86: goto L_0x0026;
                case 87: goto L_0x0026;
                case 100: goto L_0x0026;
                case 101: goto L_0x0026;
                case 102: goto L_0x0026;
                case 103: goto L_0x0026;
                default: goto L_0x0025;
            }     // Catch:{ Throwable -> 0x0056 }
        L_0x0025:
            goto L_0x0034
        L_0x0026:
            r5.VariableInitializer()     // Catch:{ Throwable -> 0x0056 }
            r1 = 2
            boolean r1 = r5.m599d(r1)     // Catch:{ Throwable -> 0x0056 }
            if (r1 == 0) goto L_0x0034
            r5.m414F(r4)     // Catch:{ Throwable -> 0x0056 }
            goto L_0x0026
        L_0x0034:
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0056 }
            if (r1 != r3) goto L_0x003d
            int r1 = r5.m616dq()     // Catch:{ Throwable -> 0x0056 }
            goto L_0x003f
        L_0x003d:
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0056 }
        L_0x003f:
            if (r1 == r4) goto L_0x0042
            goto L_0x0045
        L_0x0042:
            r5.m414F(r4)     // Catch:{ Throwable -> 0x0056 }
        L_0x0045:
            r1 = 75
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0056 }
            bsh.JJTParserState r1 = r5.f642a
            r1.mo804a(r0, r2)
            r5.mo983b(r0)
            return
        L_0x0053:
            r1 = move-exception
            r3 = 1
            goto L_0x006f
        L_0x0056:
            r1 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x0053 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0053 }
            r3 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x006e }
            if (r4 == 0) goto L_0x0064
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x006e }
            throw r1     // Catch:{ all -> 0x006e }
        L_0x0064:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x006e }
            if (r4 == 0) goto L_0x006b
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x006e }
            throw r1     // Catch:{ all -> 0x006e }
        L_0x006b:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x006e }
            throw r1     // Catch:{ all -> 0x006e }
        L_0x006e:
            r1 = move-exception
        L_0x006f:
            if (r3 == 0) goto L_0x0079
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r2)
            r5.mo983b(r0)
        L_0x0079:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.ArrayInitializer():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Assignment() {
        /*
            r5 = this;
            bsh.BSHAssignment r0 = new bsh.BSHAssignment
            r1 = 13
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 1
            r5.PrimaryExpression()     // Catch:{ Throwable -> 0x0028 }
            int r2 = r5.AssignmentOperator()     // Catch:{ Throwable -> 0x0028 }
            r0.operator = r2     // Catch:{ Throwable -> 0x0028 }
            r5.Expression()     // Catch:{ Throwable -> 0x0028 }
            bsh.JJTParserState r2 = r5.f642a
            r2.mo804a(r0, r1)
            r5.mo983b(r0)
            return
        L_0x0025:
            r2 = move-exception
            r3 = 1
            goto L_0x0041
        L_0x0028:
            r2 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x0025 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0025 }
            r3 = 0
            boolean r4 = r2 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0040 }
            if (r4 == 0) goto L_0x0036
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2     // Catch:{ all -> 0x0040 }
            throw r2     // Catch:{ all -> 0x0040 }
        L_0x0036:
            boolean r4 = r2 instanceof bsh.ParseException     // Catch:{ all -> 0x0040 }
            if (r4 == 0) goto L_0x003d
            bsh.ParseException r2 = (bsh.ParseException) r2     // Catch:{ all -> 0x0040 }
            throw r2     // Catch:{ all -> 0x0040 }
        L_0x003d:
            java.lang.Error r2 = (java.lang.Error) r2     // Catch:{ all -> 0x0040 }
            throw r2     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r2 = move-exception
        L_0x0041:
            if (r3 == 0) goto L_0x004b
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r1)
            r5.mo983b(r0)
        L_0x004b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.Assignment():void");
    }

    public final int AssignmentOperator() {
        int i;
        int dq = this.f645d == -1 ? m616dq() : this.f645d;
        int i2 = 81;
        if (dq != 81) {
            i2 = 124;
            if (dq != 124) {
                switch (dq) {
                    case 118:
                        i = 118;
                        break;
                    case 119:
                        i = 119;
                        break;
                    case 120:
                        i = 120;
                        break;
                    case 121:
                        i = 121;
                        break;
                    case 122:
                        i = 122;
                        break;
                    default:
                        switch (dq) {
                            case 126:
                                i = 126;
                                break;
                            case 127:
                                i = 127;
                                break;
                            case 128:
                                i = 128;
                                break;
                            case 129:
                                i = 129;
                                break;
                            case 130:
                                i = 130;
                                break;
                            case 131:
                                i = 131;
                                break;
                            case 132:
                                i = 132;
                                break;
                            case 133:
                                i = 133;
                                break;
                            default:
                                m414F(-1);
                                throw new ParseException();
                        }
                }
                m414F(i);
                return getToken(0).kind;
            }
        }
        m414F(i2);
        return getToken(0).kind;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Block() {
        /*
            r5 = this;
            bsh.BSHBlock r0 = new bsh.BSHBlock
            r1 = 25
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 74
            r2 = 1
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0030 }
        L_0x0015:
            boolean r1 = r5.m654w(r2)     // Catch:{ Throwable -> 0x0030 }
            if (r1 == 0) goto L_0x001f
            r5.BlockStatement()     // Catch:{ Throwable -> 0x0030 }
            goto L_0x0015
        L_0x001f:
            r1 = 75
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0030 }
            bsh.JJTParserState r1 = r5.f642a
            r1.mo804a(r0, r2)
            r5.mo983b(r0)
            return
        L_0x002d:
            r1 = move-exception
            r3 = 1
            goto L_0x0049
        L_0x0030:
            r1 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x002d }
            r3.mo806b(r0)     // Catch:{ all -> 0x002d }
            r3 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0048 }
            if (r4 == 0) goto L_0x003e
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x0048 }
            throw r1     // Catch:{ all -> 0x0048 }
        L_0x003e:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x0048 }
            if (r4 == 0) goto L_0x0045
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x0048 }
            throw r1     // Catch:{ all -> 0x0048 }
        L_0x0045:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x0048 }
            throw r1     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r1 = move-exception
        L_0x0049:
            if (r3 == 0) goto L_0x0053
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r2)
            r5.mo983b(r0)
        L_0x0053:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.Block():void");
    }

    public final void BlockStatement() {
        if (m656x(Integer.MAX_VALUE)) {
            ClassDeclaration();
        } else if (m658y(Integer.MAX_VALUE) || m660z(Integer.MAX_VALUE)) {
            MethodDeclaration();
        } else if (m405A(Integer.MAX_VALUE)) {
            TypedVariableDeclaration();
            m414F(78);
        } else if (m407B(1)) {
            Statement();
        } else {
            int dq = this.f645d == -1 ? m616dq() : this.f645d;
            if (dq != 34) {
                if (dq == 42) {
                    PackageDeclaration();
                    return;
                } else if (dq != 48) {
                    if (dq != 68) {
                        m414F(-1);
                        throw new ParseException();
                    } else {
                        FormalComment();
                        return;
                    }
                }
            }
            ImportDeclaration();
        }
    }

    public final boolean BooleanLiteral() {
        int dq = this.f645d == -1 ? m616dq() : this.f645d;
        if (dq == 26) {
            m414F(26);
            return false;
        } else if (dq != 55) {
            m414F(-1);
            throw new ParseException();
        } else {
            m414F(55);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void BreakStatement() {
        /*
            r5 = this;
            bsh.BSHReturnStatement r0 = new bsh.BSHReturnStatement
            r1 = 35
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 12
            r2 = 1
            r5.m414F(r1)     // Catch:{ all -> 0x003c }
            int r3 = r5.f645d     // Catch:{ all -> 0x003c }
            r4 = -1
            if (r3 != r4) goto L_0x001f
            int r3 = r5.m616dq()     // Catch:{ all -> 0x003c }
            goto L_0x0021
        L_0x001f:
            int r3 = r5.f645d     // Catch:{ all -> 0x003c }
        L_0x0021:
            r4 = 69
            if (r3 == r4) goto L_0x0026
            goto L_0x0029
        L_0x0026:
            r5.m414F(r4)     // Catch:{ all -> 0x003c }
        L_0x0029:
            r3 = 78
            r5.m414F(r3)     // Catch:{ all -> 0x003c }
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x003c }
            r3.mo804a(r0, r2)     // Catch:{ all -> 0x003c }
            r3 = 0
            r5.mo983b(r0)     // Catch:{ all -> 0x003a }
            r0.kind = r1     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r1 = move-exception
            goto L_0x003e
        L_0x003c:
            r1 = move-exception
            r3 = 1
        L_0x003e:
            if (r3 == 0) goto L_0x0048
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r2)
            r5.mo983b(r0)
        L_0x0048:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.BreakStatement():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void CastExpression() {
        /*
            r6 = this;
            bsh.BSHCastExpression r0 = new bsh.BSHCastExpression
            r1 = 17
            r0.<init>(r1)
            bsh.JJTParserState r1 = r6.f642a
            r1.mo808c(r0)
            r6.mo980a(r0)
            r1 = 2147483647(0x7fffffff, float:NaN)
            r2 = 1
            boolean r1 = r6.m634m(r1)     // Catch:{ Throwable -> 0x0059 }
            r3 = 73
            r4 = 72
            if (r1 == 0) goto L_0x002a
            r6.m414F(r4)     // Catch:{ Throwable -> 0x0059 }
            r6.Type()     // Catch:{ Throwable -> 0x0059 }
            r6.m414F(r3)     // Catch:{ Throwable -> 0x0059 }
            r6.UnaryExpression()     // Catch:{ Throwable -> 0x0059 }
            goto L_0x004d
        L_0x002a:
            int r1 = r6.f645d     // Catch:{ Throwable -> 0x0059 }
            r5 = -1
            if (r1 != r5) goto L_0x0034
            int r1 = r6.m616dq()     // Catch:{ Throwable -> 0x0059 }
            goto L_0x0036
        L_0x0034:
            int r1 = r6.f645d     // Catch:{ Throwable -> 0x0059 }
        L_0x0036:
            if (r1 == r4) goto L_0x0041
            r6.m414F(r5)     // Catch:{ Throwable -> 0x0059 }
            bsh.ParseException r1 = new bsh.ParseException     // Catch:{ Throwable -> 0x0059 }
            r1.<init>()     // Catch:{ Throwable -> 0x0059 }
            throw r1     // Catch:{ Throwable -> 0x0059 }
        L_0x0041:
            r6.m414F(r4)     // Catch:{ Throwable -> 0x0059 }
            r6.Type()     // Catch:{ Throwable -> 0x0059 }
            r6.m414F(r3)     // Catch:{ Throwable -> 0x0059 }
            r6.UnaryExpressionNotPlusMinus()     // Catch:{ Throwable -> 0x0059 }
        L_0x004d:
            bsh.JJTParserState r1 = r6.f642a
            r1.mo804a(r0, r2)
            r6.mo983b(r0)
            return
        L_0x0056:
            r1 = move-exception
            r3 = 1
            goto L_0x0072
        L_0x0059:
            r1 = move-exception
            bsh.JJTParserState r3 = r6.f642a     // Catch:{ all -> 0x0056 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0056 }
            r3 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0071 }
            if (r4 == 0) goto L_0x0067
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x0071 }
            throw r1     // Catch:{ all -> 0x0071 }
        L_0x0067:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x0071 }
            if (r4 == 0) goto L_0x006e
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x0071 }
            throw r1     // Catch:{ all -> 0x0071 }
        L_0x006e:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x0071 }
            throw r1     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r1 = move-exception
        L_0x0072:
            if (r3 == 0) goto L_0x007c
            bsh.JJTParserState r3 = r6.f642a
            r3.mo804a(r0, r2)
            r6.mo983b(r0)
        L_0x007c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.CastExpression():void");
    }

    public final void CastLookahead() {
        int i;
        if (m628j(2)) {
            m414F(72);
            PrimitiveType();
            return;
        }
        if (m630k(Integer.MAX_VALUE)) {
            m414F(72);
            AmbiguousName();
            m414F(76);
            i = 77;
        } else {
            if ((this.f645d == -1 ? m616dq() : this.f645d) != 72) {
                m414F(-1);
                throw new ParseException();
            }
            m414F(72);
            AmbiguousName();
            m414F(73);
            switch (this.f645d == -1 ? m616dq() : this.f645d) {
                case 26:
                case ParserConstants.NULL /*41*/:
                case 55:
                case 57:
                case ParserConstants.INTEGER_LITERAL /*60*/:
                case 64:
                case ParserConstants.CHARACTER_LITERAL /*66*/:
                case ParserConstants.STRING_LITERAL /*67*/:
                    Literal();
                    return;
                case ParserConstants.NEW /*40*/:
                    i = 40;
                    break;
                case ParserConstants.IDENTIFIER /*69*/:
                    i = 69;
                    break;
                case ParserConstants.LPAREN /*72*/:
                    m414F(72);
                    return;
                case 86:
                    i = 86;
                    break;
                case 87:
                    i = 87;
                    break;
                default:
                    m414F(-1);
                    throw new ParseException();
            }
        }
        m414F(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0090 A[SYNTHETIC, Splitter:B:43:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0098 A[Catch:{ all -> 0x0096 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a2 A[Catch:{ all -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a5 A[Catch:{ all -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ClassDeclaration() {
        /*
            r8 = this;
            bsh.BSHClassDeclaration r0 = new bsh.BSHClassDeclaration
            r1 = 1
            r0.<init>(r1)
            bsh.JJTParserState r2 = r8.f642a
            r2.mo808c(r0)
            r8.mo980a(r0)
            r2 = 0
            bsh.Modifiers r3 = r8.Modifiers(r2, r2)     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            int r4 = r8.f645d     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            r5 = -1
            if (r4 != r5) goto L_0x001d
            int r4 = r8.m616dq()     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            goto L_0x001f
        L_0x001d:
            int r4 = r8.f645d     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
        L_0x001f:
            r6 = 13
            if (r4 == r6) goto L_0x0036
            r6 = 37
            if (r4 == r6) goto L_0x0030
            r8.m414F(r5)     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            bsh.ParseException r3 = new bsh.ParseException     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            r3.<init>()     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            throw r3     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
        L_0x0030:
            r8.m414F(r6)     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            r0.f476e = r1     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            goto L_0x0039
        L_0x0036:
            r8.m414F(r6)     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
        L_0x0039:
            r4 = 69
            bsh.Token r4 = r8.m414F(r4)     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            int r6 = r8.f645d     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            if (r6 != r5) goto L_0x0048
            int r6 = r8.m616dq()     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            goto L_0x004a
        L_0x0048:
            int r6 = r8.f645d     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
        L_0x004a:
            r7 = 25
            if (r6 == r7) goto L_0x004f
            goto L_0x0057
        L_0x004f:
            r8.m414F(r7)     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            r8.AmbiguousName()     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            r0.f475d = r1     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
        L_0x0057:
            int r6 = r8.f645d     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            if (r6 != r5) goto L_0x0060
            int r5 = r8.m616dq()     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            goto L_0x0062
        L_0x0060:
            int r5 = r8.f645d     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
        L_0x0062:
            r6 = 33
            if (r5 == r6) goto L_0x0067
            goto L_0x0070
        L_0x0067:
            r8.m414F(r6)     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            int r5 = r8.NameList()     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            r0.f474c = r5     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
        L_0x0070:
            r8.Block()     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            bsh.JJTParserState r5 = r8.f642a     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            r5.mo804a(r0, r1)     // Catch:{ Throwable -> 0x008c, all -> 0x0089 }
            r8.mo983b(r0)     // Catch:{ Throwable -> 0x0086, all -> 0x0082 }
            r0.f473b = r3     // Catch:{ Throwable -> 0x0086, all -> 0x0082 }
            java.lang.String r3 = r4.image     // Catch:{ Throwable -> 0x0086, all -> 0x0082 }
            r0.f472a = r3     // Catch:{ Throwable -> 0x0086, all -> 0x0082 }
            return
        L_0x0082:
            r3 = move-exception
            r2 = r3
            r4 = 0
            goto L_0x00b2
        L_0x0086:
            r3 = move-exception
            r4 = 0
            goto L_0x008e
        L_0x0089:
            r2 = move-exception
            r4 = 1
            goto L_0x00b2
        L_0x008c:
            r3 = move-exception
            r4 = 1
        L_0x008e:
            if (r4 == 0) goto L_0x0098
            bsh.JJTParserState r5 = r8.f642a     // Catch:{ all -> 0x0096 }
            r5.mo806b(r0)     // Catch:{ all -> 0x0096 }
            goto L_0x009e
        L_0x0096:
            r2 = move-exception
            goto L_0x00b2
        L_0x0098:
            bsh.JJTParserState r2 = r8.f642a     // Catch:{ all -> 0x0096 }
            r2.mo807c()     // Catch:{ all -> 0x0096 }
            r2 = r4
        L_0x009e:
            boolean r4 = r3 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x00af }
            if (r4 == 0) goto L_0x00a5
            java.lang.RuntimeException r3 = (java.lang.RuntimeException) r3     // Catch:{ all -> 0x00af }
            throw r3     // Catch:{ all -> 0x00af }
        L_0x00a5:
            boolean r4 = r3 instanceof bsh.ParseException     // Catch:{ all -> 0x00af }
            if (r4 == 0) goto L_0x00ac
            bsh.ParseException r3 = (bsh.ParseException) r3     // Catch:{ all -> 0x00af }
            throw r3     // Catch:{ all -> 0x00af }
        L_0x00ac:
            java.lang.Error r3 = (java.lang.Error) r3     // Catch:{ all -> 0x00af }
            throw r3     // Catch:{ all -> 0x00af }
        L_0x00af:
            r3 = move-exception
            r4 = r2
            r2 = r3
        L_0x00b2:
            if (r4 == 0) goto L_0x00bc
            bsh.JJTParserState r3 = r8.f642a
            r3.mo804a(r0, r1)
            r8.mo983b(r0)
        L_0x00bc:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.ClassDeclaration():void");
    }

    public final void ConditionalAndExpression() {
        int i;
        InclusiveOrExpression();
        while (true) {
            switch (this.f645d == -1 ? m616dq() : this.f645d) {
                case 98:
                case 99:
                    switch (this.f645d == -1 ? m616dq() : this.f645d) {
                        case 98:
                            i = 98;
                            break;
                        case 99:
                            i = 99;
                            break;
                        default:
                            m414F(-1);
                            throw new ParseException();
                    }
                    Token F = m414F(i);
                    InclusiveOrExpression();
                    BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(15);
                    boolean z = true;
                    this.f642a.mo808c(bSHBinaryExpression);
                    mo980a((Node) bSHBinaryExpression);
                    try {
                        this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                        z = false;
                        mo983b((Node) bSHBinaryExpression);
                        bSHBinaryExpression.kind = F.kind;
                    } catch (Throwable th) {
                        if (z) {
                            this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                            mo983b((Node) bSHBinaryExpression);
                        }
                        throw th;
                    }
                default:
                    return;
            }
        }
    }

    public final void ConditionalExpression() {
        ConditionalOrExpression();
        if ((this.f645d == -1 ? m616dq() : this.f645d) == 88) {
            m414F(88);
            Expression();
            m414F(89);
            BSHTernaryExpression bSHTernaryExpression = new BSHTernaryExpression(14);
            this.f642a.mo808c(bSHTernaryExpression);
            mo980a((Node) bSHTernaryExpression);
            try {
                ConditionalExpression();
                this.f642a.mo803a((Node) bSHTernaryExpression, 3);
                mo983b((Node) bSHTernaryExpression);
            } catch (Throwable th) {
                if (1 != 0) {
                    this.f642a.mo803a((Node) bSHTernaryExpression, 3);
                    mo983b((Node) bSHTernaryExpression);
                }
                throw th;
            }
        }
    }

    public final void ConditionalOrExpression() {
        int i;
        ConditionalAndExpression();
        while (true) {
            switch (this.f645d == -1 ? m616dq() : this.f645d) {
                case 96:
                case 97:
                    switch (this.f645d == -1 ? m616dq() : this.f645d) {
                        case 96:
                            i = 96;
                            break;
                        case 97:
                            i = 97;
                            break;
                        default:
                            m414F(-1);
                            throw new ParseException();
                    }
                    Token F = m414F(i);
                    ConditionalAndExpression();
                    BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(15);
                    boolean z = true;
                    this.f642a.mo808c(bSHBinaryExpression);
                    mo980a((Node) bSHBinaryExpression);
                    try {
                        this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                        z = false;
                        mo983b((Node) bSHBinaryExpression);
                        bSHBinaryExpression.kind = F.kind;
                    } catch (Throwable th) {
                        if (z) {
                            this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                            mo983b((Node) bSHBinaryExpression);
                        }
                        throw th;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ContinueStatement() {
        /*
            r5 = this;
            bsh.BSHReturnStatement r0 = new bsh.BSHReturnStatement
            r1 = 35
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 19
            r2 = 1
            r5.m414F(r1)     // Catch:{ all -> 0x003c }
            int r3 = r5.f645d     // Catch:{ all -> 0x003c }
            r4 = -1
            if (r3 != r4) goto L_0x001f
            int r3 = r5.m616dq()     // Catch:{ all -> 0x003c }
            goto L_0x0021
        L_0x001f:
            int r3 = r5.f645d     // Catch:{ all -> 0x003c }
        L_0x0021:
            r4 = 69
            if (r3 == r4) goto L_0x0026
            goto L_0x0029
        L_0x0026:
            r5.m414F(r4)     // Catch:{ all -> 0x003c }
        L_0x0029:
            r3 = 78
            r5.m414F(r3)     // Catch:{ all -> 0x003c }
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x003c }
            r3.mo804a(r0, r2)     // Catch:{ all -> 0x003c }
            r3 = 0
            r5.mo983b(r0)     // Catch:{ all -> 0x003a }
            r0.kind = r1     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r1 = move-exception
            goto L_0x003e
        L_0x003c:
            r1 = move-exception
            r3 = 1
        L_0x003e:
            if (r3 == 0) goto L_0x0048
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r2)
            r5.mo983b(r0)
        L_0x0048:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.ContinueStatement():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045 A[SYNTHETIC, Splitter:B:13:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e A[Catch:{ all -> 0x004b }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058 A[Catch:{ all -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b A[Catch:{ all -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void DoStatement() {
        /*
            r6 = this;
            bsh.BSHWhileStatement r0 = new bsh.BSHWhileStatement
            r1 = 30
            r0.<init>(r1)
            bsh.JJTParserState r1 = r6.f642a
            r1.mo808c(r0)
            r6.mo980a(r0)
            r1 = 21
            r2 = 0
            r3 = 1
            r6.m414F(r1)     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            r6.Statement()     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            r1 = 59
            r6.m414F(r1)     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            r1 = 72
            r6.m414F(r1)     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            r6.Expression()     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            r1 = 73
            r6.m414F(r1)     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            r1 = 78
            r6.m414F(r1)     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            bsh.JJTParserState r1 = r6.f642a     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            r1.mo804a(r0, r3)     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            r6.mo983b(r0)     // Catch:{ Throwable -> 0x003b }
            r0.isDoStatement = r3     // Catch:{ Throwable -> 0x003b }
            return
        L_0x003b:
            r1 = move-exception
            r4 = 0
            goto L_0x0043
        L_0x003e:
            r1 = move-exception
            r2 = 1
            goto L_0x0066
        L_0x0041:
            r1 = move-exception
            r4 = 1
        L_0x0043:
            if (r4 == 0) goto L_0x004e
            bsh.JJTParserState r5 = r6.f642a     // Catch:{ all -> 0x004b }
            r5.mo806b(r0)     // Catch:{ all -> 0x004b }
            goto L_0x0054
        L_0x004b:
            r1 = move-exception
            r2 = r4
            goto L_0x0066
        L_0x004e:
            bsh.JJTParserState r2 = r6.f642a     // Catch:{ all -> 0x004b }
            r2.mo807c()     // Catch:{ all -> 0x004b }
            r2 = r4
        L_0x0054:
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0065 }
            if (r4 == 0) goto L_0x005b
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x0065 }
            throw r1     // Catch:{ all -> 0x0065 }
        L_0x005b:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x0065 }
            if (r4 == 0) goto L_0x0062
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x0065 }
            throw r1     // Catch:{ all -> 0x0065 }
        L_0x0062:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x0065 }
            throw r1     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r1 = move-exception
        L_0x0066:
            if (r2 == 0) goto L_0x0070
            bsh.JJTParserState r2 = r6.f642a
            r2.mo804a(r0, r3)
            r6.mo983b(r0)
        L_0x0070:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.DoStatement():void");
    }

    public final void EmptyStatement() {
        m414F(78);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void EnhancedForStatement() {
        /*
            r10 = this;
            bsh.BSHEnhancedForStatement r0 = new bsh.BSHEnhancedForStatement
            r1 = 32
            r0.<init>(r1)
            bsh.JJTParserState r1 = r10.f642a
            r1.mo808c(r0)
            r10.mo980a(r0)
            r1 = 4
            r2 = 0
            r3 = 1
            boolean r1 = r10.m411D(r1)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r4 = 73
            r5 = 89
            r6 = 69
            r7 = 72
            r8 = 30
            if (r1 == 0) goto L_0x0048
            r10.m414F(r8)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r10.m414F(r7)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            bsh.Token r1 = r10.m414F(r6)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r10.m414F(r5)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r10.Expression()     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r10.m414F(r4)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r10.Statement()     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            bsh.JJTParserState r4 = r10.f642a     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r4.mo804a(r0, r3)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r10.mo983b(r0)     // Catch:{ Throwable -> 0x0045 }
            java.lang.String r1 = r1.image     // Catch:{ Throwable -> 0x0045 }
        L_0x0042:
            r0.f477a = r1     // Catch:{ Throwable -> 0x0045 }
            return
        L_0x0045:
            r1 = move-exception
            r4 = 0
            goto L_0x0089
        L_0x0048:
            int r1 = r10.f645d     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r9 = -1
            if (r1 != r9) goto L_0x0052
            int r1 = r10.m616dq()     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            goto L_0x0054
        L_0x0052:
            int r1 = r10.f645d     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
        L_0x0054:
            if (r1 == r8) goto L_0x005f
            r10.m414F(r9)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            bsh.ParseException r1 = new bsh.ParseException     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r1.<init>()     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            throw r1     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
        L_0x005f:
            r10.m414F(r8)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r10.m414F(r7)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r10.Type()     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            bsh.Token r1 = r10.m414F(r6)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r10.m414F(r5)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r10.Expression()     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r10.m414F(r4)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r10.Statement()     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            bsh.JJTParserState r4 = r10.f642a     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r4.mo804a(r0, r3)     // Catch:{ Throwable -> 0x0087, all -> 0x0084 }
            r10.mo983b(r0)     // Catch:{ Throwable -> 0x0045 }
            java.lang.String r1 = r1.image     // Catch:{ Throwable -> 0x0045 }
            goto L_0x0042
            return
        L_0x0084:
            r1 = move-exception
            r2 = 1
            goto L_0x00ac
        L_0x0087:
            r1 = move-exception
            r4 = 1
        L_0x0089:
            if (r4 == 0) goto L_0x0094
            bsh.JJTParserState r5 = r10.f642a     // Catch:{ all -> 0x0091 }
            r5.mo806b(r0)     // Catch:{ all -> 0x0091 }
            goto L_0x009a
        L_0x0091:
            r1 = move-exception
            r2 = r4
            goto L_0x00ac
        L_0x0094:
            bsh.JJTParserState r2 = r10.f642a     // Catch:{ all -> 0x0091 }
            r2.mo807c()     // Catch:{ all -> 0x0091 }
            r2 = r4
        L_0x009a:
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x00ab }
            if (r4 == 0) goto L_0x00a1
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x00ab }
            throw r1     // Catch:{ all -> 0x00ab }
        L_0x00a1:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x00ab }
            if (r4 == 0) goto L_0x00a8
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x00ab }
            throw r1     // Catch:{ all -> 0x00ab }
        L_0x00a8:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x00ab }
            throw r1     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r1 = move-exception
        L_0x00ac:
            if (r2 == 0) goto L_0x00b6
            bsh.JJTParserState r2 = r10.f642a
            r2.mo804a(r0, r3)
            r10.mo983b(r0)
        L_0x00b6:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.EnhancedForStatement():void");
    }

    public final void EqualityExpression() {
        Token token2;
        InstanceOfExpression();
        while (true) {
            int dq = this.f645d == -1 ? m616dq() : this.f645d;
            if (dq == 90 || dq == 95) {
                int dq2 = this.f645d == -1 ? m616dq() : this.f645d;
                if (dq2 == 90) {
                    token2 = m414F(90);
                } else if (dq2 != 95) {
                    m414F(-1);
                    throw new ParseException();
                } else {
                    token2 = m414F(95);
                }
                InstanceOfExpression();
                BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(15);
                boolean z = true;
                this.f642a.mo808c(bSHBinaryExpression);
                mo980a((Node) bSHBinaryExpression);
                try {
                    this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                    z = false;
                    mo983b((Node) bSHBinaryExpression);
                    bSHBinaryExpression.kind = token2.kind;
                } catch (Throwable th) {
                    if (z) {
                        this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                        mo983b((Node) bSHBinaryExpression);
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    public final void ExclusiveOrExpression() {
        AndExpression();
        while (true) {
            if ((this.f645d == -1 ? m616dq() : this.f645d) == 110) {
                Token F = m414F(110);
                AndExpression();
                BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(15);
                boolean z = true;
                this.f642a.mo808c(bSHBinaryExpression);
                mo980a((Node) bSHBinaryExpression);
                try {
                    this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                    z = false;
                    mo983b((Node) bSHBinaryExpression);
                    bSHBinaryExpression.kind = F.kind;
                } catch (Throwable th) {
                    if (z) {
                        this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                        mo983b((Node) bSHBinaryExpression);
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    public final void Expression() {
        if (m624h(Integer.MAX_VALUE)) {
            Assignment();
            return;
        }
        switch (this.f645d == -1 ? m616dq() : this.f645d) {
            case 11:
            case 14:
            case 17:
            case 22:
            case 26:
            case 29:
            case 36:
            case ParserConstants.LONG /*38*/:
            case ParserConstants.NEW /*40*/:
            case ParserConstants.NULL /*41*/:
            case 47:
            case 55:
            case 57:
            case ParserConstants.INTEGER_LITERAL /*60*/:
            case 64:
            case ParserConstants.CHARACTER_LITERAL /*66*/:
            case ParserConstants.STRING_LITERAL /*67*/:
            case ParserConstants.IDENTIFIER /*69*/:
            case ParserConstants.LPAREN /*72*/:
            case 86:
            case 87:
            case 100:
            case 101:
            case 102:
            case 103:
                ConditionalExpression();
                return;
            default:
                m414F(-1);
                throw new ParseException();
        }
    }

    public final void ForInit() {
        if (m413E(Integer.MAX_VALUE)) {
            TypedVariableDeclaration();
            return;
        }
        switch (this.f645d == -1 ? m616dq() : this.f645d) {
            case 11:
            case 14:
            case 17:
            case 22:
            case 26:
            case 29:
            case 36:
            case ParserConstants.LONG /*38*/:
            case ParserConstants.NEW /*40*/:
            case ParserConstants.NULL /*41*/:
            case 47:
            case 55:
            case 57:
            case ParserConstants.INTEGER_LITERAL /*60*/:
            case 64:
            case ParserConstants.CHARACTER_LITERAL /*66*/:
            case ParserConstants.STRING_LITERAL /*67*/:
            case ParserConstants.IDENTIFIER /*69*/:
            case ParserConstants.LPAREN /*72*/:
            case 86:
            case 87:
            case 100:
            case 101:
            case 102:
            case 103:
                StatementExpressionList();
                return;
            default:
                m414F(-1);
                throw new ParseException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ForStatement() {
        /*
            r5 = this;
            bsh.BSHForStatement r0 = new bsh.BSHForStatement
            r1 = 31
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 30
            r2 = 1
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0073 }
            r1 = 72
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0073 }
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0073 }
            r3 = -1
            if (r1 != r3) goto L_0x0024
            int r1 = r5.m616dq()     // Catch:{ Throwable -> 0x0073 }
            goto L_0x0026
        L_0x0024:
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0073 }
        L_0x0026:
            switch(r1) {
                case 10: goto L_0x002a;
                case 11: goto L_0x002a;
                case 14: goto L_0x002a;
                case 17: goto L_0x002a;
                case 22: goto L_0x002a;
                case 26: goto L_0x002a;
                case 27: goto L_0x002a;
                case 29: goto L_0x002a;
                case 36: goto L_0x002a;
                case 38: goto L_0x002a;
                case 39: goto L_0x002a;
                case 40: goto L_0x002a;
                case 41: goto L_0x002a;
                case 43: goto L_0x002a;
                case 44: goto L_0x002a;
                case 45: goto L_0x002a;
                case 47: goto L_0x002a;
                case 48: goto L_0x002a;
                case 49: goto L_0x002a;
                case 51: goto L_0x002a;
                case 52: goto L_0x002a;
                case 55: goto L_0x002a;
                case 57: goto L_0x002a;
                case 58: goto L_0x002a;
                case 60: goto L_0x002a;
                case 64: goto L_0x002a;
                case 66: goto L_0x002a;
                case 67: goto L_0x002a;
                case 69: goto L_0x002a;
                case 72: goto L_0x002a;
                case 86: goto L_0x002a;
                case 87: goto L_0x002a;
                case 100: goto L_0x002a;
                case 101: goto L_0x002a;
                case 102: goto L_0x002a;
                case 103: goto L_0x002a;
                default: goto L_0x0029;
            }     // Catch:{ Throwable -> 0x0073 }
        L_0x0029:
            goto L_0x002f
        L_0x002a:
            r5.ForInit()     // Catch:{ Throwable -> 0x0073 }
            r0.hasForInit = r2     // Catch:{ Throwable -> 0x0073 }
        L_0x002f:
            r1 = 78
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0073 }
            int r4 = r5.f645d     // Catch:{ Throwable -> 0x0073 }
            if (r4 != r3) goto L_0x003d
            int r4 = r5.m616dq()     // Catch:{ Throwable -> 0x0073 }
            goto L_0x003f
        L_0x003d:
            int r4 = r5.f645d     // Catch:{ Throwable -> 0x0073 }
        L_0x003f:
            switch(r4) {
                case 11: goto L_0x0043;
                case 14: goto L_0x0043;
                case 17: goto L_0x0043;
                case 22: goto L_0x0043;
                case 26: goto L_0x0043;
                case 29: goto L_0x0043;
                case 36: goto L_0x0043;
                case 38: goto L_0x0043;
                case 40: goto L_0x0043;
                case 41: goto L_0x0043;
                case 47: goto L_0x0043;
                case 55: goto L_0x0043;
                case 57: goto L_0x0043;
                case 60: goto L_0x0043;
                case 64: goto L_0x0043;
                case 66: goto L_0x0043;
                case 67: goto L_0x0043;
                case 69: goto L_0x0043;
                case 72: goto L_0x0043;
                case 86: goto L_0x0043;
                case 87: goto L_0x0043;
                case 100: goto L_0x0043;
                case 101: goto L_0x0043;
                case 102: goto L_0x0043;
                case 103: goto L_0x0043;
                default: goto L_0x0042;
            }     // Catch:{ Throwable -> 0x0073 }
        L_0x0042:
            goto L_0x0048
        L_0x0043:
            r5.Expression()     // Catch:{ Throwable -> 0x0073 }
            r0.hasExpression = r2     // Catch:{ Throwable -> 0x0073 }
        L_0x0048:
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0073 }
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0073 }
            if (r1 != r3) goto L_0x0054
            int r1 = r5.m616dq()     // Catch:{ Throwable -> 0x0073 }
            goto L_0x0056
        L_0x0054:
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0073 }
        L_0x0056:
            switch(r1) {
                case 11: goto L_0x005a;
                case 14: goto L_0x005a;
                case 17: goto L_0x005a;
                case 22: goto L_0x005a;
                case 26: goto L_0x005a;
                case 29: goto L_0x005a;
                case 36: goto L_0x005a;
                case 38: goto L_0x005a;
                case 40: goto L_0x005a;
                case 41: goto L_0x005a;
                case 47: goto L_0x005a;
                case 55: goto L_0x005a;
                case 57: goto L_0x005a;
                case 60: goto L_0x005a;
                case 64: goto L_0x005a;
                case 66: goto L_0x005a;
                case 67: goto L_0x005a;
                case 69: goto L_0x005a;
                case 72: goto L_0x005a;
                case 86: goto L_0x005a;
                case 87: goto L_0x005a;
                case 100: goto L_0x005a;
                case 101: goto L_0x005a;
                case 102: goto L_0x005a;
                case 103: goto L_0x005a;
                default: goto L_0x0059;
            }     // Catch:{ Throwable -> 0x0073 }
        L_0x0059:
            goto L_0x005f
        L_0x005a:
            r5.ForUpdate()     // Catch:{ Throwable -> 0x0073 }
            r0.hasForUpdate = r2     // Catch:{ Throwable -> 0x0073 }
        L_0x005f:
            r1 = 73
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0073 }
            r5.Statement()     // Catch:{ Throwable -> 0x0073 }
            bsh.JJTParserState r1 = r5.f642a
            r1.mo804a(r0, r2)
            r5.mo983b(r0)
            return
        L_0x0070:
            r1 = move-exception
            r3 = 1
            goto L_0x008c
        L_0x0073:
            r1 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x0070 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0070 }
            r3 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x008b }
            if (r4 == 0) goto L_0x0081
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x008b }
            throw r1     // Catch:{ all -> 0x008b }
        L_0x0081:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x008b }
            if (r4 == 0) goto L_0x0088
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x008b }
            throw r1     // Catch:{ all -> 0x008b }
        L_0x0088:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x008b }
            throw r1     // Catch:{ all -> 0x008b }
        L_0x008b:
            r1 = move-exception
        L_0x008c:
            if (r3 == 0) goto L_0x0096
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r2)
            r5.mo983b(r0)
        L_0x0096:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.ForStatement():void");
    }

    public final void ForUpdate() {
        StatementExpressionList();
    }

    public final void FormalComment() {
        BSHFormalComment bSHFormalComment = new BSHFormalComment(26);
        this.f642a.mo808c(bSHFormalComment);
        mo980a((Node) bSHFormalComment);
        boolean z = true;
        try {
            Token F = m414F(68);
            this.f642a.mo804a((Node) bSHFormalComment, this.f643b);
            z = false;
            mo983b((Node) bSHFormalComment);
            bSHFormalComment.text = F.image;
        } catch (Throwable th) {
            if (z) {
                this.f642a.mo804a((Node) bSHFormalComment, this.f643b);
                mo983b((Node) bSHFormalComment);
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void FormalParameter() {
        /*
            r6 = this;
            bsh.BSHFormalParameter r0 = new bsh.BSHFormalParameter
            r1 = 8
            r0.<init>(r1)
            bsh.JJTParserState r1 = r6.f642a
            r1.mo808c(r0)
            r6.mo980a(r0)
            r1 = 2
            r2 = 0
            r3 = 1
            boolean r1 = r6.m618e(r1)     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
            r4 = 69
            if (r1 == 0) goto L_0x0031
            r6.Type()     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
            bsh.Token r1 = r6.m414F(r4)     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
            bsh.JJTParserState r4 = r6.f642a     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
            r4.mo804a(r0, r3)     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
            r6.mo983b(r0)     // Catch:{ Throwable -> 0x002e }
            java.lang.String r1 = r1.image     // Catch:{ Throwable -> 0x002e }
        L_0x002b:
            r0.name = r1     // Catch:{ Throwable -> 0x002e }
            return
        L_0x002e:
            r1 = move-exception
            r4 = 0
            goto L_0x005d
        L_0x0031:
            int r1 = r6.f645d     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
            r5 = -1
            if (r1 != r5) goto L_0x003b
            int r1 = r6.m616dq()     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
            goto L_0x003d
        L_0x003b:
            int r1 = r6.f645d     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
        L_0x003d:
            if (r1 == r4) goto L_0x0048
            r6.m414F(r5)     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
            bsh.ParseException r1 = new bsh.ParseException     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
            r1.<init>()     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
            throw r1     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
        L_0x0048:
            bsh.Token r1 = r6.m414F(r4)     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
            bsh.JJTParserState r4 = r6.f642a     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
            r4.mo804a(r0, r3)     // Catch:{ Throwable -> 0x005b, all -> 0x0058 }
            r6.mo983b(r0)     // Catch:{ Throwable -> 0x002e }
            java.lang.String r1 = r1.image     // Catch:{ Throwable -> 0x002e }
            goto L_0x002b
            return
        L_0x0058:
            r1 = move-exception
            r2 = 1
            goto L_0x0080
        L_0x005b:
            r1 = move-exception
            r4 = 1
        L_0x005d:
            if (r4 == 0) goto L_0x0068
            bsh.JJTParserState r5 = r6.f642a     // Catch:{ all -> 0x0065 }
            r5.mo806b(r0)     // Catch:{ all -> 0x0065 }
            goto L_0x006e
        L_0x0065:
            r1 = move-exception
            r2 = r4
            goto L_0x0080
        L_0x0068:
            bsh.JJTParserState r2 = r6.f642a     // Catch:{ all -> 0x0065 }
            r2.mo807c()     // Catch:{ all -> 0x0065 }
            r2 = r4
        L_0x006e:
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x007f }
            if (r4 == 0) goto L_0x0075
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x007f }
            throw r1     // Catch:{ all -> 0x007f }
        L_0x0075:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x007f }
            if (r4 == 0) goto L_0x007c
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x007f }
            throw r1     // Catch:{ all -> 0x007f }
        L_0x007c:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x007f }
            throw r1     // Catch:{ all -> 0x007f }
        L_0x007f:
            r1 = move-exception
        L_0x0080:
            if (r2 == 0) goto L_0x008a
            bsh.JJTParserState r2 = r6.f642a
            r2.mo804a(r0, r3)
            r6.mo983b(r0)
        L_0x008a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.FormalParameter():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void FormalParameters() {
        /*
            r5 = this;
            bsh.BSHFormalParameters r0 = new bsh.BSHFormalParameters
            r1 = 7
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 72
            r2 = 1
            r5.m414F(r1)     // Catch:{ Throwable -> 0x006c }
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x006c }
            r3 = -1
            if (r1 != r3) goto L_0x001e
            int r1 = r5.m616dq()     // Catch:{ Throwable -> 0x006c }
            goto L_0x0020
        L_0x001e:
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x006c }
        L_0x0020:
            r4 = 11
            if (r1 == r4) goto L_0x0045
            r4 = 14
            if (r1 == r4) goto L_0x0045
            r4 = 17
            if (r1 == r4) goto L_0x0045
            r4 = 22
            if (r1 == r4) goto L_0x0045
            r4 = 29
            if (r1 == r4) goto L_0x0045
            r4 = 36
            if (r1 == r4) goto L_0x0045
            r4 = 38
            if (r1 == r4) goto L_0x0045
            r4 = 47
            if (r1 == r4) goto L_0x0045
            r4 = 69
            if (r1 == r4) goto L_0x0045
            goto L_0x0057
        L_0x0045:
            r5.FormalParameter()     // Catch:{ Throwable -> 0x006c }
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x006c }
            if (r1 != r3) goto L_0x0051
            int r1 = r5.m616dq()     // Catch:{ Throwable -> 0x006c }
            goto L_0x0053
        L_0x0051:
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x006c }
        L_0x0053:
            r4 = 79
            if (r1 == r4) goto L_0x0065
        L_0x0057:
            r1 = 73
            r5.m414F(r1)     // Catch:{ Throwable -> 0x006c }
            bsh.JJTParserState r1 = r5.f642a
            r1.mo804a(r0, r2)
            r5.mo983b(r0)
            return
        L_0x0065:
            r5.m414F(r4)     // Catch:{ Throwable -> 0x006c }
            goto L_0x0045
        L_0x0069:
            r1 = move-exception
            r3 = 1
            goto L_0x0085
        L_0x006c:
            r1 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x0069 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0069 }
            r3 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0084 }
            if (r4 == 0) goto L_0x007a
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x0084 }
            throw r1     // Catch:{ all -> 0x0084 }
        L_0x007a:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x0084 }
            if (r4 == 0) goto L_0x0081
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x0084 }
            throw r1     // Catch:{ all -> 0x0084 }
        L_0x0081:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x0084 }
            throw r1     // Catch:{ all -> 0x0084 }
        L_0x0084:
            r1 = move-exception
        L_0x0085:
            if (r3 == 0) goto L_0x008f
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r2)
            r5.mo983b(r0)
        L_0x008f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.FormalParameters():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void IfStatement() {
        /*
            r5 = this;
            bsh.BSHIfStatement r0 = new bsh.BSHIfStatement
            r1 = 29
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 32
            r2 = 1
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0048 }
            r1 = 72
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0048 }
            r5.Expression()     // Catch:{ Throwable -> 0x0048 }
            r1 = 73
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0048 }
            r5.Statement()     // Catch:{ Throwable -> 0x0048 }
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0048 }
            r3 = -1
            if (r1 != r3) goto L_0x002f
            int r1 = r5.m616dq()     // Catch:{ Throwable -> 0x0048 }
            goto L_0x0031
        L_0x002f:
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0048 }
        L_0x0031:
            r3 = 23
            if (r1 == r3) goto L_0x0036
            goto L_0x003c
        L_0x0036:
            r5.m414F(r3)     // Catch:{ Throwable -> 0x0048 }
            r5.Statement()     // Catch:{ Throwable -> 0x0048 }
        L_0x003c:
            bsh.JJTParserState r1 = r5.f642a
            r1.mo804a(r0, r2)
            r5.mo983b(r0)
            return
        L_0x0045:
            r1 = move-exception
            r3 = 1
            goto L_0x0061
        L_0x0048:
            r1 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x0045 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0045 }
            r3 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0060 }
            if (r4 == 0) goto L_0x0056
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x0060 }
            throw r1     // Catch:{ all -> 0x0060 }
        L_0x0056:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x0060 }
            if (r4 == 0) goto L_0x005d
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x0060 }
            throw r1     // Catch:{ all -> 0x0060 }
        L_0x005d:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x0060 }
            throw r1     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r1 = move-exception
        L_0x0061:
            if (r3 == 0) goto L_0x006b
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r2)
            r5.mo983b(r0)
        L_0x006b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.IfStatement():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0099 A[SYNTHETIC, Splitter:B:47:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a2 A[Catch:{ all -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ac A[Catch:{ all -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00af A[Catch:{ all -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ImportDeclaration() {
        /*
            r10 = this;
            bsh.BSHImportDeclaration r0 = new bsh.BSHImportDeclaration
            r1 = 4
            r0.<init>(r1)
            bsh.JJTParserState r1 = r10.f642a
            r1.mo808c(r0)
            r10.mo980a(r0)
            r1 = 3
            r2 = 0
            r3 = 1
            boolean r1 = r10.m545c(r1)     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            r4 = 78
            r5 = 104(0x68, float:1.46E-43)
            r6 = 34
            r7 = -1
            if (r1 == 0) goto L_0x0065
            int r1 = r10.f645d     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            if (r1 != r7) goto L_0x0027
            int r1 = r10.m616dq()     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            goto L_0x0029
        L_0x0027:
            int r1 = r10.f645d     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        L_0x0029:
            r8 = 48
            r9 = 0
            if (r1 == r8) goto L_0x0030
            r1 = r9
            goto L_0x0034
        L_0x0030:
            bsh.Token r1 = r10.m414F(r8)     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        L_0x0034:
            r10.m414F(r6)     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            r10.AmbiguousName()     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            int r6 = r10.f645d     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            if (r6 != r7) goto L_0x0043
            int r6 = r10.m616dq()     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            goto L_0x0045
        L_0x0043:
            int r6 = r10.f645d     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        L_0x0045:
            r7 = 80
            if (r6 == r7) goto L_0x004a
            goto L_0x0051
        L_0x004a:
            bsh.Token r9 = r10.m414F(r7)     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            r10.m414F(r5)     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        L_0x0051:
            r10.m414F(r4)     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            bsh.JJTParserState r4 = r10.f642a     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            r4.mo804a(r0, r3)     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            r10.mo983b(r0)     // Catch:{ Throwable -> 0x008f }
            if (r1 == 0) goto L_0x0060
            r0.staticImport = r3     // Catch:{ Throwable -> 0x008f }
        L_0x0060:
            if (r9 == 0) goto L_0x008e
            r0.importPackage = r3     // Catch:{ Throwable -> 0x008f }
            return
        L_0x0065:
            int r1 = r10.f645d     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            if (r1 != r7) goto L_0x006e
            int r1 = r10.m616dq()     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            goto L_0x0070
        L_0x006e:
            int r1 = r10.f645d     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        L_0x0070:
            if (r1 == r6) goto L_0x007b
            r10.m414F(r7)     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            bsh.ParseException r1 = new bsh.ParseException     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            r1.<init>()     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            throw r1     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        L_0x007b:
            r10.m414F(r6)     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            r10.m414F(r5)     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            r10.m414F(r4)     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            bsh.JJTParserState r1 = r10.f642a     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            r1.mo804a(r0, r3)     // Catch:{ Throwable -> 0x0095, all -> 0x0092 }
            r10.mo983b(r0)     // Catch:{ Throwable -> 0x008f }
            r0.superImport = r3     // Catch:{ Throwable -> 0x008f }
        L_0x008e:
            return
        L_0x008f:
            r1 = move-exception
            r4 = 0
            goto L_0x0097
        L_0x0092:
            r1 = move-exception
            r2 = 1
            goto L_0x00ba
        L_0x0095:
            r1 = move-exception
            r4 = 1
        L_0x0097:
            if (r4 == 0) goto L_0x00a2
            bsh.JJTParserState r5 = r10.f642a     // Catch:{ all -> 0x009f }
            r5.mo806b(r0)     // Catch:{ all -> 0x009f }
            goto L_0x00a8
        L_0x009f:
            r1 = move-exception
            r2 = r4
            goto L_0x00ba
        L_0x00a2:
            bsh.JJTParserState r2 = r10.f642a     // Catch:{ all -> 0x009f }
            r2.mo807c()     // Catch:{ all -> 0x009f }
            r2 = r4
        L_0x00a8:
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x00b9 }
            if (r4 == 0) goto L_0x00af
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x00b9 }
            throw r1     // Catch:{ all -> 0x00b9 }
        L_0x00af:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x00b9 }
            if (r4 == 0) goto L_0x00b6
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x00b9 }
            throw r1     // Catch:{ all -> 0x00b9 }
        L_0x00b6:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x00b9 }
            throw r1     // Catch:{ all -> 0x00b9 }
        L_0x00b9:
            r1 = move-exception
        L_0x00ba:
            if (r2 == 0) goto L_0x00c4
            bsh.JJTParserState r2 = r10.f642a
            r2.mo804a(r0, r3)
            r10.mo983b(r0)
        L_0x00c4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.ImportDeclaration():void");
    }

    public final void InclusiveOrExpression() {
        int i;
        ExclusiveOrExpression();
        while (true) {
            switch (this.f645d == -1 ? m616dq() : this.f645d) {
                case 108:
                case 109:
                    switch (this.f645d == -1 ? m616dq() : this.f645d) {
                        case 108:
                            i = 108;
                            break;
                        case 109:
                            i = 109;
                            break;
                        default:
                            m414F(-1);
                            throw new ParseException();
                    }
                    Token F = m414F(i);
                    ExclusiveOrExpression();
                    BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(15);
                    boolean z = true;
                    this.f642a.mo808c(bSHBinaryExpression);
                    mo980a((Node) bSHBinaryExpression);
                    try {
                        this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                        z = false;
                        mo983b((Node) bSHBinaryExpression);
                        bSHBinaryExpression.kind = F.kind;
                    } catch (Throwable th) {
                        if (z) {
                            this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                            mo983b((Node) bSHBinaryExpression);
                        }
                        throw th;
                    }
                default:
                    return;
            }
        }
    }

    public final void InstanceOfExpression() {
        RelationalExpression();
        if ((this.f645d == -1 ? m616dq() : this.f645d) == 35) {
            Token F = m414F(35);
            Type();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(15);
            boolean z = true;
            this.f642a.mo808c(bSHBinaryExpression);
            mo980a((Node) bSHBinaryExpression);
            try {
                this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                z = false;
                mo983b((Node) bSHBinaryExpression);
                bSHBinaryExpression.kind = F.kind;
            } catch (Throwable th) {
                if (z) {
                    this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                    mo983b((Node) bSHBinaryExpression);
                }
                throw th;
            }
        }
    }

    public final void LabeledStatement() {
        m414F(69);
        m414F(89);
        Statement();
    }

    public final boolean Line() {
        if ((this.f645d == -1 ? m616dq() : this.f645d) == 0) {
            m414F(0);
            Interpreter.debug("End of File!");
            return true;
        } else if (m437a(1)) {
            BlockStatement();
            return false;
        } else {
            m414F(-1);
            throw new ParseException();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:27|28|29) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:38|39|40) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:69|70|71) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r4 = new java.lang.StringBuffer();
        r4.append("Error parsing string: ");
        r4.append(r3.image);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
        throw mo979a(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r4 = new java.lang.StringBuffer();
        r4.append("Error parsing character: ");
        r4.append(r3.image);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ae, code lost:
        throw mo979a(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r4 = new java.lang.StringBuffer();
        r4.append("Error or number too big for integer type: ");
        r4.append(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x014e, code lost:
        throw mo979a(r4.toString());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0060 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0097 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0139 */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01c8  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0060=Splitter:B:27:0x0060, B:38:0x0097=Splitter:B:38:0x0097, B:69:0x0139=Splitter:B:69:0x0139} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Literal() {
        /*
            r7 = this;
            bsh.BSHLiteral r0 = new bsh.BSHLiteral
            r1 = 21
            r0.<init>(r1)
            bsh.JJTParserState r1 = r7.f642a
            r1.mo808c(r0)
            r7.mo980a(r0)
            r1 = 0
            r2 = 1
            int r3 = r7.f645d     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r4 = -1
            if (r3 != r4) goto L_0x001b
            int r3 = r7.m616dq()     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            goto L_0x001d
        L_0x001b:
            int r3 = r7.f645d     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
        L_0x001d:
            r5 = 26
            if (r3 == r5) goto L_0x0185
            r5 = 41
            if (r3 == r5) goto L_0x0177
            r5 = 55
            if (r3 == r5) goto L_0x0185
            r5 = 57
            if (r3 == r5) goto L_0x0167
            r5 = 60
            if (r3 == r5) goto L_0x0109
            r5 = 64
            if (r3 == r5) goto L_0x00af
            switch(r3) {
                case 66: goto L_0x0078;
                case 67: goto L_0x0041;
                default: goto L_0x0038;
            }     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
        L_0x0038:
            r7.m414F(r4)     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            bsh.ParseException r3 = new bsh.ParseException     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r3.<init>()     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            throw r3     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
        L_0x0041:
            r3 = 67
            bsh.Token r3 = r7.m414F(r3)     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            bsh.JJTParserState r4 = r7.f642a     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r4.mo804a(r0, r2)     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r7.mo983b(r0)     // Catch:{ Throwable -> 0x0199 }
            java.lang.String r4 = r3.image     // Catch:{ Exception -> 0x0060 }
            java.lang.String r5 = r3.image     // Catch:{ Exception -> 0x0060 }
            int r5 = r5.length()     // Catch:{ Exception -> 0x0060 }
            int r5 = r5 - r2
            java.lang.String r4 = r4.substring(r2, r5)     // Catch:{ Exception -> 0x0060 }
            r0.mo621a(r4)     // Catch:{ Exception -> 0x0060 }
            return
        L_0x0060:
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ Throwable -> 0x0199 }
            r4.<init>()     // Catch:{ Throwable -> 0x0199 }
            java.lang.String r5 = "Error parsing string: "
            r4.append(r5)     // Catch:{ Throwable -> 0x0199 }
            java.lang.String r3 = r3.image     // Catch:{ Throwable -> 0x0199 }
            r4.append(r3)     // Catch:{ Throwable -> 0x0199 }
            java.lang.String r3 = r4.toString()     // Catch:{ Throwable -> 0x0199 }
            bsh.ParseException r3 = r7.mo979a(r3)     // Catch:{ Throwable -> 0x0199 }
            throw r3     // Catch:{ Throwable -> 0x0199 }
        L_0x0078:
            r3 = 66
            bsh.Token r3 = r7.m414F(r3)     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            bsh.JJTParserState r4 = r7.f642a     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r4.mo804a(r0, r2)     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r7.mo983b(r0)     // Catch:{ Throwable -> 0x0199 }
            java.lang.String r4 = r3.image     // Catch:{ Exception -> 0x0097 }
            java.lang.String r5 = r3.image     // Catch:{ Exception -> 0x0097 }
            int r5 = r5.length()     // Catch:{ Exception -> 0x0097 }
            int r5 = r5 - r2
            java.lang.String r4 = r4.substring(r2, r5)     // Catch:{ Exception -> 0x0097 }
            r0.charSetup(r4)     // Catch:{ Exception -> 0x0097 }
            return
        L_0x0097:
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ Throwable -> 0x0199 }
            r4.<init>()     // Catch:{ Throwable -> 0x0199 }
            java.lang.String r5 = "Error parsing character: "
            r4.append(r5)     // Catch:{ Throwable -> 0x0199 }
            java.lang.String r3 = r3.image     // Catch:{ Throwable -> 0x0199 }
            r4.append(r3)     // Catch:{ Throwable -> 0x0199 }
            java.lang.String r3 = r4.toString()     // Catch:{ Throwable -> 0x0199 }
            bsh.ParseException r3 = r7.mo979a(r3)     // Catch:{ Throwable -> 0x0199 }
            throw r3     // Catch:{ Throwable -> 0x0199 }
        L_0x00af:
            bsh.Token r3 = r7.m414F(r5)     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            bsh.JJTParserState r4 = r7.f642a     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r4.mo804a(r0, r2)     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r7.mo983b(r0)     // Catch:{ Throwable -> 0x0199 }
            java.lang.String r3 = r3.image     // Catch:{ Throwable -> 0x0199 }
            int r4 = r3.length()     // Catch:{ Throwable -> 0x0199 }
            int r4 = r4 - r2
            char r4 = r3.charAt(r4)     // Catch:{ Throwable -> 0x0199 }
            r5 = 102(0x66, float:1.43E-43)
            if (r4 == r5) goto L_0x00f1
            r5 = 70
            if (r4 != r5) goto L_0x00cf
            goto L_0x00f1
        L_0x00cf:
            r5 = 100
            if (r4 == r5) goto L_0x00d7
            r5 = 68
            if (r4 != r5) goto L_0x00e0
        L_0x00d7:
            int r4 = r3.length()     // Catch:{ Throwable -> 0x0199 }
            int r4 = r4 - r2
            java.lang.String r3 = r3.substring(r1, r4)     // Catch:{ Throwable -> 0x0199 }
        L_0x00e0:
            bsh.Primitive r4 = new bsh.Primitive     // Catch:{ Throwable -> 0x0199 }
            java.lang.Double r5 = new java.lang.Double     // Catch:{ Throwable -> 0x0199 }
            r5.<init>(r3)     // Catch:{ Throwable -> 0x0199 }
            double r5 = r5.doubleValue()     // Catch:{ Throwable -> 0x0199 }
            r4.<init>(r5)     // Catch:{ Throwable -> 0x0199 }
        L_0x00ee:
            r0.value = r4     // Catch:{ Throwable -> 0x0199 }
            return
        L_0x00f1:
            int r4 = r3.length()     // Catch:{ Throwable -> 0x0199 }
            int r4 = r4 - r2
            java.lang.String r3 = r3.substring(r1, r4)     // Catch:{ Throwable -> 0x0199 }
            bsh.Primitive r4 = new bsh.Primitive     // Catch:{ Throwable -> 0x0199 }
            java.lang.Float r5 = new java.lang.Float     // Catch:{ Throwable -> 0x0199 }
            r5.<init>(r3)     // Catch:{ Throwable -> 0x0199 }
            float r3 = r5.floatValue()     // Catch:{ Throwable -> 0x0199 }
            r4.<init>(r3)     // Catch:{ Throwable -> 0x0199 }
            goto L_0x00ee
        L_0x0109:
            bsh.Token r3 = r7.m414F(r5)     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            bsh.JJTParserState r4 = r7.f642a     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r4.mo804a(r0, r2)     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r7.mo983b(r0)     // Catch:{ Throwable -> 0x0199 }
            java.lang.String r3 = r3.image     // Catch:{ Throwable -> 0x0199 }
            int r4 = r3.length()     // Catch:{ Throwable -> 0x0199 }
            int r4 = r4 - r2
            char r4 = r3.charAt(r4)     // Catch:{ Throwable -> 0x0199 }
            r5 = 108(0x6c, float:1.51E-43)
            if (r4 == r5) goto L_0x014f
            r5 = 76
            if (r4 != r5) goto L_0x0129
            goto L_0x014f
        L_0x0129:
            bsh.Primitive r4 = new bsh.Primitive     // Catch:{ NumberFormatException -> 0x0139 }
            java.lang.Integer r5 = java.lang.Integer.decode(r3)     // Catch:{ NumberFormatException -> 0x0139 }
            int r5 = r5.intValue()     // Catch:{ NumberFormatException -> 0x0139 }
            r4.<init>(r5)     // Catch:{ NumberFormatException -> 0x0139 }
            r0.value = r4     // Catch:{ NumberFormatException -> 0x0139 }
            return
        L_0x0139:
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ Throwable -> 0x0199 }
            r4.<init>()     // Catch:{ Throwable -> 0x0199 }
            java.lang.String r5 = "Error or number too big for integer type: "
            r4.append(r5)     // Catch:{ Throwable -> 0x0199 }
            r4.append(r3)     // Catch:{ Throwable -> 0x0199 }
            java.lang.String r3 = r4.toString()     // Catch:{ Throwable -> 0x0199 }
            bsh.ParseException r3 = r7.mo979a(r3)     // Catch:{ Throwable -> 0x0199 }
            throw r3     // Catch:{ Throwable -> 0x0199 }
        L_0x014f:
            int r4 = r3.length()     // Catch:{ Throwable -> 0x0199 }
            int r4 = r4 - r2
            java.lang.String r3 = r3.substring(r1, r4)     // Catch:{ Throwable -> 0x0199 }
            bsh.Primitive r4 = new bsh.Primitive     // Catch:{ Throwable -> 0x0199 }
            java.lang.Long r5 = new java.lang.Long     // Catch:{ Throwable -> 0x0199 }
            r5.<init>(r3)     // Catch:{ Throwable -> 0x0199 }
            long r5 = r5.longValue()     // Catch:{ Throwable -> 0x0199 }
            r4.<init>(r5)     // Catch:{ Throwable -> 0x0199 }
            goto L_0x00ee
        L_0x0167:
            r7.VoidLiteral()     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            bsh.JJTParserState r3 = r7.f642a     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r3.mo804a(r0, r2)     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r7.mo983b(r0)     // Catch:{ Throwable -> 0x0199 }
            bsh.Primitive r3 = bsh.Primitive.VOID     // Catch:{ Throwable -> 0x0199 }
        L_0x0174:
            r0.value = r3     // Catch:{ Throwable -> 0x0199 }
            return
        L_0x0177:
            r7.NullLiteral()     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            bsh.JJTParserState r3 = r7.f642a     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r3.mo804a(r0, r2)     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r7.mo983b(r0)     // Catch:{ Throwable -> 0x0199 }
            bsh.Primitive r3 = bsh.Primitive.NULL     // Catch:{ Throwable -> 0x0199 }
            goto L_0x0174
        L_0x0185:
            boolean r3 = r7.BooleanLiteral()     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            bsh.JJTParserState r4 = r7.f642a     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r4.mo804a(r0, r2)     // Catch:{ Throwable -> 0x01a0, all -> 0x019c }
            r7.mo983b(r0)     // Catch:{ Throwable -> 0x0199 }
            bsh.Primitive r4 = new bsh.Primitive     // Catch:{ Throwable -> 0x0199 }
            r4.<init>(r3)     // Catch:{ Throwable -> 0x0199 }
            goto L_0x00ee
            return
        L_0x0199:
            r3 = move-exception
            r4 = 0
            goto L_0x01a2
        L_0x019c:
            r1 = move-exception
            r3 = r1
            r1 = 1
            goto L_0x01c6
        L_0x01a0:
            r3 = move-exception
            r4 = 1
        L_0x01a2:
            if (r4 == 0) goto L_0x01ae
            bsh.JJTParserState r5 = r7.f642a     // Catch:{ all -> 0x01aa }
            r5.mo806b(r0)     // Catch:{ all -> 0x01aa }
            goto L_0x01b4
        L_0x01aa:
            r1 = move-exception
            r3 = r1
            r1 = r4
            goto L_0x01c6
        L_0x01ae:
            bsh.JJTParserState r1 = r7.f642a     // Catch:{ all -> 0x01aa }
            r1.mo807c()     // Catch:{ all -> 0x01aa }
            r1 = r4
        L_0x01b4:
            boolean r4 = r3 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x01c5 }
            if (r4 == 0) goto L_0x01bb
            java.lang.RuntimeException r3 = (java.lang.RuntimeException) r3     // Catch:{ all -> 0x01c5 }
            throw r3     // Catch:{ all -> 0x01c5 }
        L_0x01bb:
            boolean r4 = r3 instanceof bsh.ParseException     // Catch:{ all -> 0x01c5 }
            if (r4 == 0) goto L_0x01c2
            bsh.ParseException r3 = (bsh.ParseException) r3     // Catch:{ all -> 0x01c5 }
            throw r3     // Catch:{ all -> 0x01c5 }
        L_0x01c2:
            java.lang.Error r3 = (java.lang.Error) r3     // Catch:{ all -> 0x01c5 }
            throw r3     // Catch:{ all -> 0x01c5 }
        L_0x01c5:
            r3 = move-exception
        L_0x01c6:
            if (r1 == 0) goto L_0x01d0
            bsh.JJTParserState r1 = r7.f642a
            r1.mo804a(r0, r2)
            r7.mo983b(r0)
        L_0x01d0:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.Literal():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void MethodDeclaration() {
        /*
            r7 = this;
            bsh.BSHMethodDeclaration r0 = new bsh.BSHMethodDeclaration
            r1 = 2
            r0.<init>(r1)
            bsh.JJTParserState r1 = r7.f642a
            r1.mo808c(r0)
            r7.mo980a(r0)
            r1 = 0
            r2 = 1
            bsh.Modifiers r3 = r7.Modifiers(r2, r1)     // Catch:{ Throwable -> 0x00ba }
            r0.modifiers = r3     // Catch:{ Throwable -> 0x00ba }
            r3 = 2147483647(0x7fffffff, float:NaN)
            boolean r3 = r7.m491b(r3)     // Catch:{ Throwable -> 0x00ba }
            r4 = 69
            r5 = -1
            if (r3 == 0) goto L_0x002b
            bsh.Token r3 = r7.m414F(r4)     // Catch:{ Throwable -> 0x00ba }
            java.lang.String r3 = r3.image     // Catch:{ Throwable -> 0x00ba }
        L_0x0028:
            r0.name = r3     // Catch:{ Throwable -> 0x00ba }
            goto L_0x006f
        L_0x002b:
            int r3 = r7.f645d     // Catch:{ Throwable -> 0x00ba }
            if (r3 != r5) goto L_0x0034
            int r3 = r7.m616dq()     // Catch:{ Throwable -> 0x00ba }
            goto L_0x0036
        L_0x0034:
            int r3 = r7.f645d     // Catch:{ Throwable -> 0x00ba }
        L_0x0036:
            r6 = 11
            if (r3 == r6) goto L_0x0065
            r6 = 14
            if (r3 == r6) goto L_0x0065
            r6 = 17
            if (r3 == r6) goto L_0x0065
            r6 = 22
            if (r3 == r6) goto L_0x0065
            r6 = 29
            if (r3 == r6) goto L_0x0065
            r6 = 36
            if (r3 == r6) goto L_0x0065
            r6 = 38
            if (r3 == r6) goto L_0x0065
            r6 = 47
            if (r3 == r6) goto L_0x0065
            r6 = 57
            if (r3 == r6) goto L_0x0065
            if (r3 == r4) goto L_0x0065
            r7.m414F(r5)     // Catch:{ Throwable -> 0x00ba }
            bsh.ParseException r3 = new bsh.ParseException     // Catch:{ Throwable -> 0x00ba }
            r3.<init>()     // Catch:{ Throwable -> 0x00ba }
            throw r3     // Catch:{ Throwable -> 0x00ba }
        L_0x0065:
            r7.ReturnType()     // Catch:{ Throwable -> 0x00ba }
            bsh.Token r3 = r7.m414F(r4)     // Catch:{ Throwable -> 0x00ba }
            java.lang.String r3 = r3.image     // Catch:{ Throwable -> 0x00ba }
            goto L_0x0028
        L_0x006f:
            r7.FormalParameters()     // Catch:{ Throwable -> 0x00ba }
            int r3 = r7.f645d     // Catch:{ Throwable -> 0x00ba }
            if (r3 != r5) goto L_0x007b
            int r3 = r7.m616dq()     // Catch:{ Throwable -> 0x00ba }
            goto L_0x007d
        L_0x007b:
            int r3 = r7.f645d     // Catch:{ Throwable -> 0x00ba }
        L_0x007d:
            r4 = 54
            if (r3 == r4) goto L_0x0082
            goto L_0x008b
        L_0x0082:
            r7.m414F(r4)     // Catch:{ Throwable -> 0x00ba }
            int r3 = r7.NameList()     // Catch:{ Throwable -> 0x00ba }
            r0.f491f = r3     // Catch:{ Throwable -> 0x00ba }
        L_0x008b:
            int r3 = r7.f645d     // Catch:{ Throwable -> 0x00ba }
            if (r3 != r5) goto L_0x0094
            int r3 = r7.m616dq()     // Catch:{ Throwable -> 0x00ba }
            goto L_0x0096
        L_0x0094:
            int r3 = r7.f645d     // Catch:{ Throwable -> 0x00ba }
        L_0x0096:
            r4 = 74
            if (r3 == r4) goto L_0x00ab
            r4 = 78
            if (r3 == r4) goto L_0x00a7
            r7.m414F(r5)     // Catch:{ Throwable -> 0x00ba }
            bsh.ParseException r3 = new bsh.ParseException     // Catch:{ Throwable -> 0x00ba }
            r3.<init>()     // Catch:{ Throwable -> 0x00ba }
            throw r3     // Catch:{ Throwable -> 0x00ba }
        L_0x00a7:
            r7.m414F(r4)     // Catch:{ Throwable -> 0x00ba }
            goto L_0x00ae
        L_0x00ab:
            r7.Block()     // Catch:{ Throwable -> 0x00ba }
        L_0x00ae:
            bsh.JJTParserState r1 = r7.f642a
            r1.mo804a(r0, r2)
            r7.mo983b(r0)
            return
        L_0x00b7:
            r1 = move-exception
            r3 = 1
            goto L_0x00d4
        L_0x00ba:
            r3 = move-exception
            bsh.JJTParserState r4 = r7.f642a     // Catch:{ all -> 0x00b7 }
            r4.mo806b(r0)     // Catch:{ all -> 0x00b7 }
            boolean r4 = r3 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x00d1 }
            if (r4 == 0) goto L_0x00c7
            java.lang.RuntimeException r3 = (java.lang.RuntimeException) r3     // Catch:{ all -> 0x00d1 }
            throw r3     // Catch:{ all -> 0x00d1 }
        L_0x00c7:
            boolean r4 = r3 instanceof bsh.ParseException     // Catch:{ all -> 0x00d1 }
            if (r4 == 0) goto L_0x00ce
            bsh.ParseException r3 = (bsh.ParseException) r3     // Catch:{ all -> 0x00d1 }
            throw r3     // Catch:{ all -> 0x00d1 }
        L_0x00ce:
            java.lang.Error r3 = (java.lang.Error) r3     // Catch:{ all -> 0x00d1 }
            throw r3     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            r3 = move-exception
            r1 = r3
            r3 = 0
        L_0x00d4:
            if (r3 == 0) goto L_0x00de
            bsh.JJTParserState r3 = r7.f642a
            r3.mo804a(r0, r2)
            r7.mo983b(r0)
        L_0x00de:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.MethodDeclaration():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void MethodInvocation() {
        /*
            r5 = this;
            bsh.BSHMethodInvocation r0 = new bsh.BSHMethodInvocation
            r1 = 19
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 1
            r5.AmbiguousName()     // Catch:{ Throwable -> 0x0022 }
            r5.Arguments()     // Catch:{ Throwable -> 0x0022 }
            bsh.JJTParserState r2 = r5.f642a
            r2.mo804a(r0, r1)
            r5.mo983b(r0)
            return
        L_0x001f:
            r2 = move-exception
            r3 = 1
            goto L_0x003b
        L_0x0022:
            r2 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x001f }
            r3.mo806b(r0)     // Catch:{ all -> 0x001f }
            r3 = 0
            boolean r4 = r2 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x003a }
            if (r4 == 0) goto L_0x0030
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2     // Catch:{ all -> 0x003a }
            throw r2     // Catch:{ all -> 0x003a }
        L_0x0030:
            boolean r4 = r2 instanceof bsh.ParseException     // Catch:{ all -> 0x003a }
            if (r4 == 0) goto L_0x0037
            bsh.ParseException r2 = (bsh.ParseException) r2     // Catch:{ all -> 0x003a }
            throw r2     // Catch:{ all -> 0x003a }
        L_0x0037:
            java.lang.Error r2 = (java.lang.Error) r2     // Catch:{ all -> 0x003a }
            throw r2     // Catch:{ all -> 0x003a }
        L_0x003a:
            r2 = move-exception
        L_0x003b:
            if (r3 == 0) goto L_0x0045
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r1)
            r5.mo983b(r0)
        L_0x0045:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.MethodInvocation():void");
    }

    public final Modifiers Modifiers(int i, boolean z) {
        int i2;
        Modifiers modifiers = null;
        while (true) {
            switch (this.f645d == -1 ? m616dq() : this.f645d) {
                case 10:
                case 27:
                case ParserConstants.NATIVE /*39*/:
                case ParserConstants.PRIVATE /*43*/:
                case ParserConstants.PROTECTED /*44*/:
                case ParserConstants.PUBLIC /*45*/:
                case 48:
                case 49:
                case 51:
                case 52:
                case 58:
                    switch (this.f645d == -1 ? m616dq() : this.f645d) {
                        case 10:
                            i2 = 10;
                            break;
                        case 27:
                            i2 = 27;
                            break;
                        case ParserConstants.NATIVE /*39*/:
                            i2 = 39;
                            break;
                        case ParserConstants.PRIVATE /*43*/:
                            i2 = 43;
                            break;
                        case ParserConstants.PROTECTED /*44*/:
                            i2 = 44;
                            break;
                        case ParserConstants.PUBLIC /*45*/:
                            i2 = 45;
                            break;
                        case 48:
                            i2 = 48;
                            break;
                        case 49:
                            i2 = 49;
                            break;
                        case 51:
                            i2 = 51;
                            break;
                        case 52:
                            i2 = 52;
                            break;
                        case 58:
                            i2 = 58;
                            break;
                        default:
                            m414F(-1);
                            throw new ParseException();
                    }
                    m414F(i2);
                    if (!z) {
                        if (modifiers == null) {
                            try {
                                modifiers = new Modifiers();
                            } catch (IllegalStateException e) {
                                throw mo979a(e.getMessage());
                            }
                        }
                        modifiers.addModifier(i, getToken(0).image);
                    }
                default:
                    return modifiers;
            }
        }
    }

    public final void MultiplicativeExpression() {
        Token token2;
        int i;
        UnaryExpression();
        while (true) {
            int dq = this.f645d == -1 ? m616dq() : this.f645d;
            if (dq != 111) {
                switch (dq) {
                    case 104:
                    case 105:
                        break;
                    default:
                        return;
                }
            }
            int dq2 = this.f645d == -1 ? m616dq() : this.f645d;
            if (dq2 != 111) {
                switch (dq2) {
                    case 104:
                        i = 104;
                        break;
                    case 105:
                        i = 105;
                        break;
                    default:
                        m414F(-1);
                        throw new ParseException();
                }
                token2 = m414F(i);
            } else {
                token2 = m414F(111);
            }
            UnaryExpression();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(15);
            boolean z = true;
            this.f642a.mo808c(bSHBinaryExpression);
            mo980a((Node) bSHBinaryExpression);
            try {
                this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                z = false;
                mo983b((Node) bSHBinaryExpression);
                bSHBinaryExpression.kind = token2.kind;
            } catch (Throwable th) {
                if (z) {
                    this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                    mo983b((Node) bSHBinaryExpression);
                }
                throw th;
            }
        }
    }

    public final int NameList() {
        AmbiguousName();
        int i = 1;
        while (true) {
            if ((this.f645d == -1 ? m616dq() : this.f645d) != 79) {
                return i;
            }
            m414F(79);
            AmbiguousName();
            i++;
        }
    }

    public final void NullLiteral() {
        m414F(41);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void PackageDeclaration() {
        /*
            r5 = this;
            bsh.BSHPackageDeclaration r0 = new bsh.BSHPackageDeclaration
            r1 = 3
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 42
            r2 = 1
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0023 }
            r5.AmbiguousName()     // Catch:{ Throwable -> 0x0023 }
            bsh.JJTParserState r1 = r5.f642a
            r1.mo804a(r0, r2)
            r5.mo983b(r0)
            return
        L_0x0020:
            r1 = move-exception
            r3 = 1
            goto L_0x003c
        L_0x0023:
            r1 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x0020 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0020 }
            r3 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x003b }
            if (r4 == 0) goto L_0x0031
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x003b }
            throw r1     // Catch:{ all -> 0x003b }
        L_0x0031:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x003b }
            if (r4 == 0) goto L_0x0038
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x003b }
            throw r1     // Catch:{ all -> 0x003b }
        L_0x0038:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x003b }
            throw r1     // Catch:{ all -> 0x003b }
        L_0x003b:
            r1 = move-exception
        L_0x003c:
            if (r3 == 0) goto L_0x0046
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r2)
            r5.mo983b(r0)
        L_0x0046:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.PackageDeclaration():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void PostfixExpression() {
        /*
            r4 = this;
            r0 = 2147483647(0x7fffffff, float:NaN)
            boolean r0 = r4.m632l(r0)
            r1 = -1
            if (r0 == 0) goto L_0x005c
            r4.PrimaryExpression()
            int r0 = r4.f645d
            if (r0 != r1) goto L_0x0016
            int r0 = r4.m616dq()
            goto L_0x0018
        L_0x0016:
            int r0 = r4.f645d
        L_0x0018:
            switch(r0) {
                case 100: goto L_0x0027;
                case 101: goto L_0x0024;
                default: goto L_0x001b;
            }
        L_0x001b:
            r4.m414F(r1)
            bsh.ParseException r0 = new bsh.ParseException
            r0.<init>()
            throw r0
        L_0x0024:
            r0 = 101(0x65, float:1.42E-43)
            goto L_0x0029
        L_0x0027:
            r0 = 100
        L_0x0029:
            bsh.Token r0 = r4.m414F(r0)
            bsh.BSHUnaryExpression r1 = new bsh.BSHUnaryExpression
            r2 = 16
            r1.<init>(r2)
            bsh.JJTParserState r2 = r4.f642a
            r2.mo808c(r1)
            r4.mo980a(r1)
            r2 = 1
            bsh.JJTParserState r3 = r4.f642a     // Catch:{ all -> 0x004f }
            r3.mo803a(r1, r2)     // Catch:{ all -> 0x004f }
            r3 = 0
            r4.mo983b(r1)     // Catch:{ all -> 0x004d }
            int r0 = r0.kind     // Catch:{ all -> 0x004d }
            r1.kind = r0     // Catch:{ all -> 0x004d }
            r1.postfix = r2     // Catch:{ all -> 0x004d }
            return
        L_0x004d:
            r0 = move-exception
            goto L_0x0051
        L_0x004f:
            r0 = move-exception
            r3 = 1
        L_0x0051:
            if (r3 == 0) goto L_0x005b
            bsh.JJTParserState r3 = r4.f642a
            r3.mo803a(r1, r2)
            r4.mo983b(r1)
        L_0x005b:
            throw r0
        L_0x005c:
            int r0 = r4.f645d
            if (r0 != r1) goto L_0x0065
            int r0 = r4.m616dq()
            goto L_0x0067
        L_0x0065:
            int r0 = r4.f645d
        L_0x0067:
            switch(r0) {
                case 11: goto L_0x0073;
                case 14: goto L_0x0073;
                case 17: goto L_0x0073;
                case 22: goto L_0x0073;
                case 26: goto L_0x0073;
                case 29: goto L_0x0073;
                case 36: goto L_0x0073;
                case 38: goto L_0x0073;
                case 40: goto L_0x0073;
                case 41: goto L_0x0073;
                case 47: goto L_0x0073;
                case 55: goto L_0x0073;
                case 57: goto L_0x0073;
                case 60: goto L_0x0073;
                case 64: goto L_0x0073;
                case 66: goto L_0x0073;
                case 67: goto L_0x0073;
                case 69: goto L_0x0073;
                case 72: goto L_0x0073;
                default: goto L_0x006a;
            }
        L_0x006a:
            r4.m414F(r1)
            bsh.ParseException r0 = new bsh.ParseException
            r0.<init>()
            throw r0
        L_0x0073:
            r4.PrimaryExpression()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.PostfixExpression():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void PreDecrementExpression() {
        /*
            r4 = this;
            r0 = 101(0x65, float:1.42E-43)
            bsh.Token r0 = r4.m414F(r0)
            r4.PrimaryExpression()
            bsh.BSHUnaryExpression r1 = new bsh.BSHUnaryExpression
            r2 = 16
            r1.<init>(r2)
            bsh.JJTParserState r2 = r4.f642a
            r2.mo808c(r1)
            r4.mo980a(r1)
            r2 = 1
            bsh.JJTParserState r3 = r4.f642a     // Catch:{ all -> 0x0029 }
            r3.mo803a(r1, r2)     // Catch:{ all -> 0x0029 }
            r3 = 0
            r4.mo983b(r1)     // Catch:{ all -> 0x0027 }
            int r0 = r0.kind     // Catch:{ all -> 0x0027 }
            r1.kind = r0     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r0 = move-exception
            goto L_0x002b
        L_0x0029:
            r0 = move-exception
            r3 = 1
        L_0x002b:
            if (r3 == 0) goto L_0x0035
            bsh.JJTParserState r3 = r4.f642a
            r3.mo803a(r1, r2)
            r4.mo983b(r1)
        L_0x0035:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.PreDecrementExpression():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void PreIncrementExpression() {
        /*
            r4 = this;
            r0 = 100
            bsh.Token r0 = r4.m414F(r0)
            r4.PrimaryExpression()
            bsh.BSHUnaryExpression r1 = new bsh.BSHUnaryExpression
            r2 = 16
            r1.<init>(r2)
            bsh.JJTParserState r2 = r4.f642a
            r2.mo808c(r1)
            r4.mo980a(r1)
            r2 = 1
            bsh.JJTParserState r3 = r4.f642a     // Catch:{ all -> 0x0029 }
            r3.mo803a(r1, r2)     // Catch:{ all -> 0x0029 }
            r3 = 0
            r4.mo983b(r1)     // Catch:{ all -> 0x0027 }
            int r0 = r0.kind     // Catch:{ all -> 0x0027 }
            r1.kind = r0     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r0 = move-exception
            goto L_0x002b
        L_0x0029:
            r0 = move-exception
            r3 = 1
        L_0x002b:
            if (r3 == 0) goto L_0x0035
            bsh.JJTParserState r3 = r4.f642a
            r3.mo803a(r1, r2)
            r4.mo983b(r1)
        L_0x0035:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.PreIncrementExpression():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void PrimaryExpression() {
        /*
            r5 = this;
            bsh.BSHPrimaryExpression r0 = new bsh.BSHPrimaryExpression
            r1 = 18
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 1
            r5.PrimaryPrefix()     // Catch:{ Throwable -> 0x003b }
        L_0x0013:
            int r2 = r5.f645d     // Catch:{ Throwable -> 0x003b }
            r3 = -1
            if (r2 != r3) goto L_0x001d
            int r2 = r5.m616dq()     // Catch:{ Throwable -> 0x003b }
            goto L_0x001f
        L_0x001d:
            int r2 = r5.f645d     // Catch:{ Throwable -> 0x003b }
        L_0x001f:
            r3 = 74
            if (r2 == r3) goto L_0x0034
            r3 = 76
            if (r2 == r3) goto L_0x0034
            r3 = 80
            if (r2 == r3) goto L_0x0034
            bsh.JJTParserState r2 = r5.f642a
            r2.mo804a(r0, r1)
            r5.mo983b(r0)
            return
        L_0x0034:
            r5.PrimarySuffix()     // Catch:{ Throwable -> 0x003b }
            goto L_0x0013
        L_0x0038:
            r2 = move-exception
            r3 = 1
            goto L_0x0054
        L_0x003b:
            r2 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x0038 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0038 }
            r3 = 0
            boolean r4 = r2 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0053 }
            if (r4 == 0) goto L_0x0049
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2     // Catch:{ all -> 0x0053 }
            throw r2     // Catch:{ all -> 0x0053 }
        L_0x0049:
            boolean r4 = r2 instanceof bsh.ParseException     // Catch:{ all -> 0x0053 }
            if (r4 == 0) goto L_0x0050
            bsh.ParseException r2 = (bsh.ParseException) r2     // Catch:{ all -> 0x0053 }
            throw r2     // Catch:{ all -> 0x0053 }
        L_0x0050:
            java.lang.Error r2 = (java.lang.Error) r2     // Catch:{ all -> 0x0053 }
            throw r2     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r2 = move-exception
        L_0x0054:
            if (r3 == 0) goto L_0x005e
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r1)
            r5.mo983b(r0)
        L_0x005e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.PrimaryExpression():void");
    }

    public final void PrimaryPrefix() {
        switch (this.f645d == -1 ? m616dq() : this.f645d) {
            case 26:
            case ParserConstants.NULL /*41*/:
            case 55:
            case 57:
            case ParserConstants.INTEGER_LITERAL /*60*/:
            case 64:
            case ParserConstants.CHARACTER_LITERAL /*66*/:
            case ParserConstants.STRING_LITERAL /*67*/:
                Literal();
                return;
            case ParserConstants.NEW /*40*/:
                AllocationExpression();
                return;
            case ParserConstants.LPAREN /*72*/:
                m414F(72);
                Expression();
                m414F(73);
                return;
            default:
                if (m636n(Integer.MAX_VALUE)) {
                    MethodInvocation();
                    return;
                } else if (m638o(Integer.MAX_VALUE)) {
                    Type();
                    return;
                } else {
                    if ((this.f645d == -1 ? m616dq() : this.f645d) != 69) {
                        m414F(-1);
                        throw new ParseException();
                    } else {
                        AmbiguousName();
                        return;
                    }
                }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00af A[SYNTHETIC, Splitter:B:49:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b8 A[Catch:{ all -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c2 A[Catch:{ all -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c5 A[Catch:{ all -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void PrimarySuffix() {
        /*
            r8 = this;
            bsh.BSHPrimarySuffix r0 = new bsh.BSHPrimarySuffix
            r1 = 20
            r0.<init>(r1)
            bsh.JJTParserState r1 = r8.f642a
            r1.mo808c(r0)
            r8.mo980a(r0)
            r1 = 2
            r2 = 0
            r3 = 1
            boolean r4 = r8.m640p(r1)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r5 = 80
            if (r4 == 0) goto L_0x0031
            r8.m414F(r5)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r1 = 13
            r8.m414F(r1)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            bsh.JJTParserState r1 = r8.f642a     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r1.mo804a(r0, r3)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r8.mo983b(r0)     // Catch:{ Throwable -> 0x002d }
            r0.operation = r2     // Catch:{ Throwable -> 0x002d }
            return
        L_0x002d:
            r1 = move-exception
            r4 = 0
            goto L_0x00ad
        L_0x0031:
            int r4 = r8.f645d     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r6 = -1
            if (r4 != r6) goto L_0x003b
            int r4 = r8.m616dq()     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            goto L_0x003d
        L_0x003b:
            int r4 = r8.f645d     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
        L_0x003d:
            r7 = 74
            if (r4 == r7) goto L_0x0091
            r7 = 76
            if (r4 == r7) goto L_0x007b
            if (r4 == r5) goto L_0x0050
            r8.m414F(r6)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            bsh.ParseException r1 = new bsh.ParseException     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r1.<init>()     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            throw r1     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
        L_0x0050:
            r8.m414F(r5)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r4 = 69
            bsh.Token r4 = r8.m414F(r4)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            int r5 = r8.f645d     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            if (r5 != r6) goto L_0x0062
            int r5 = r8.m616dq()     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            goto L_0x0064
        L_0x0062:
            int r5 = r8.f645d     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
        L_0x0064:
            r6 = 72
            if (r5 == r6) goto L_0x0069
            goto L_0x006c
        L_0x0069:
            r8.Arguments()     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
        L_0x006c:
            bsh.JJTParserState r5 = r8.f642a     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r5.mo804a(r0, r3)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r8.mo983b(r0)     // Catch:{ Throwable -> 0x002d }
            r0.operation = r1     // Catch:{ Throwable -> 0x002d }
            java.lang.String r1 = r4.image     // Catch:{ Throwable -> 0x002d }
            r0.field = r1     // Catch:{ Throwable -> 0x002d }
            return
        L_0x007b:
            r8.m414F(r7)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r8.Expression()     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r1 = 77
            r8.m414F(r1)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            bsh.JJTParserState r1 = r8.f642a     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r1.mo804a(r0, r3)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r8.mo983b(r0)     // Catch:{ Throwable -> 0x002d }
            r0.operation = r3     // Catch:{ Throwable -> 0x002d }
            return
        L_0x0091:
            r8.m414F(r7)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r8.Expression()     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r1 = 75
            r8.m414F(r1)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            bsh.JJTParserState r1 = r8.f642a     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r1.mo804a(r0, r3)     // Catch:{ Throwable -> 0x00ab, all -> 0x00a8 }
            r8.mo983b(r0)     // Catch:{ Throwable -> 0x002d }
            r1 = 3
            r0.operation = r1     // Catch:{ Throwable -> 0x002d }
            return
        L_0x00a8:
            r1 = move-exception
            r2 = 1
            goto L_0x00d0
        L_0x00ab:
            r1 = move-exception
            r4 = 1
        L_0x00ad:
            if (r4 == 0) goto L_0x00b8
            bsh.JJTParserState r5 = r8.f642a     // Catch:{ all -> 0x00b5 }
            r5.mo806b(r0)     // Catch:{ all -> 0x00b5 }
            goto L_0x00be
        L_0x00b5:
            r1 = move-exception
            r2 = r4
            goto L_0x00d0
        L_0x00b8:
            bsh.JJTParserState r2 = r8.f642a     // Catch:{ all -> 0x00b5 }
            r2.mo807c()     // Catch:{ all -> 0x00b5 }
            r2 = r4
        L_0x00be:
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x00cf }
            if (r4 == 0) goto L_0x00c5
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x00cf }
            throw r1     // Catch:{ all -> 0x00cf }
        L_0x00c5:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x00cf }
            if (r4 == 0) goto L_0x00cc
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x00cf }
            throw r1     // Catch:{ all -> 0x00cf }
        L_0x00cc:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x00cf }
            throw r1     // Catch:{ all -> 0x00cf }
        L_0x00cf:
            r1 = move-exception
        L_0x00d0:
            if (r2 == 0) goto L_0x00da
            bsh.JJTParserState r2 = r8.f642a
            r2.mo804a(r0, r3)
            r8.mo983b(r0)
        L_0x00da:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.PrimarySuffix():void");
    }

    public final void PrimitiveType() {
        Class cls;
        BSHPrimitiveType bSHPrimitiveType = new BSHPrimitiveType(11);
        this.f642a.mo808c(bSHPrimitiveType);
        mo980a((Node) bSHPrimitiveType);
        boolean z = false;
        try {
            int dq = this.f645d == -1 ? m616dq() : this.f645d;
            if (dq == 11) {
                m414F(11);
                this.f642a.mo804a((Node) bSHPrimitiveType, true);
                mo983b((Node) bSHPrimitiveType);
                cls = Boolean.TYPE;
            } else if (dq == 14) {
                m414F(14);
                this.f642a.mo804a((Node) bSHPrimitiveType, true);
                mo983b((Node) bSHPrimitiveType);
                cls = Byte.TYPE;
            } else if (dq == 17) {
                m414F(17);
                this.f642a.mo804a((Node) bSHPrimitiveType, true);
                mo983b((Node) bSHPrimitiveType);
                cls = Character.TYPE;
            } else if (dq == 22) {
                m414F(22);
                this.f642a.mo804a((Node) bSHPrimitiveType, true);
                mo983b((Node) bSHPrimitiveType);
                cls = Double.TYPE;
            } else if (dq == 29) {
                m414F(29);
                this.f642a.mo804a((Node) bSHPrimitiveType, true);
                mo983b((Node) bSHPrimitiveType);
                cls = Float.TYPE;
            } else if (dq == 36) {
                m414F(36);
                this.f642a.mo804a((Node) bSHPrimitiveType, true);
                mo983b((Node) bSHPrimitiveType);
                cls = Integer.TYPE;
            } else if (dq == 38) {
                m414F(38);
                this.f642a.mo804a((Node) bSHPrimitiveType, true);
                mo983b((Node) bSHPrimitiveType);
                cls = Long.TYPE;
            } else if (dq != 47) {
                m414F(-1);
                throw new ParseException();
            } else {
                m414F(47);
                this.f642a.mo804a((Node) bSHPrimitiveType, true);
                try {
                    mo983b((Node) bSHPrimitiveType);
                    cls = Short.TYPE;
                } catch (Throwable th) {
                    th = th;
                }
            }
            bSHPrimitiveType.type = cls;
        } catch (Throwable th2) {
            th = th2;
            z = true;
            if (z) {
                this.f642a.mo804a((Node) bSHPrimitiveType, true);
                mo983b((Node) bSHPrimitiveType);
            }
            throw th;
        }
    }

    public void ReInit(ParserTokenManager parserTokenManager) {
        this.token_source = parserTokenManager;
        this.token = new Token();
        this.f645d = -1;
        this.f642a.mo801a();
    }

    public void ReInit(InputStream inputStream) {
        this.f644c.ReInit(inputStream, 1, 1);
        this.token_source.ReInit(this.f644c);
        this.token = new Token();
        this.f645d = -1;
        this.f642a.mo801a();
    }

    public void ReInit(Reader reader) {
        this.f644c.ReInit(reader, 1, 1);
        this.token_source.ReInit(this.f644c);
        this.token = new Token();
        this.f645d = -1;
        this.f642a.mo801a();
    }

    public final void RelationalExpression() {
        int i;
        ShiftExpression();
        while (true) {
            int dq = this.f645d == -1 ? m616dq() : this.f645d;
            switch (dq) {
                case 82:
                case 83:
                case 84:
                case 85:
                    break;
                default:
                    switch (dq) {
                        case 91:
                        case 92:
                        case 93:
                        case 94:
                            break;
                        default:
                            return;
                    }
            }
            int dq2 = this.f645d == -1 ? m616dq() : this.f645d;
            switch (dq2) {
                case 82:
                    i = 82;
                    break;
                case 83:
                    i = 83;
                    break;
                case 84:
                    i = 84;
                    break;
                case 85:
                    i = 85;
                    break;
                default:
                    switch (dq2) {
                        case 91:
                            i = 91;
                            break;
                        case 92:
                            i = 92;
                            break;
                        case 93:
                            i = 93;
                            break;
                        case 94:
                            i = 94;
                            break;
                        default:
                            m414F(-1);
                            throw new ParseException();
                    }
            }
            Token F = m414F(i);
            ShiftExpression();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(15);
            boolean z = true;
            this.f642a.mo808c(bSHBinaryExpression);
            mo980a((Node) bSHBinaryExpression);
            try {
                this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                z = false;
                mo983b((Node) bSHBinaryExpression);
                bSHBinaryExpression.kind = F.kind;
            } catch (Throwable th) {
                if (z) {
                    this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                    mo983b((Node) bSHBinaryExpression);
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0047 A[SYNTHETIC, Splitter:B:22:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f A[Catch:{ all -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059 A[Catch:{ all -> 0x0066 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005c A[Catch:{ all -> 0x0066 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ReturnStatement() {
        /*
            r6 = this;
            bsh.BSHReturnStatement r0 = new bsh.BSHReturnStatement
            r1 = 35
            r0.<init>(r1)
            bsh.JJTParserState r1 = r6.f642a
            r1.mo808c(r0)
            r6.mo980a(r0)
            r1 = 0
            r2 = 46
            r3 = 1
            r6.m414F(r2)     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
            int r4 = r6.f645d     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
            r5 = -1
            if (r4 != r5) goto L_0x0020
            int r4 = r6.m616dq()     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
            goto L_0x0022
        L_0x0020:
            int r4 = r6.f645d     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
        L_0x0022:
            switch(r4) {
                case 11: goto L_0x0026;
                case 14: goto L_0x0026;
                case 17: goto L_0x0026;
                case 22: goto L_0x0026;
                case 26: goto L_0x0026;
                case 29: goto L_0x0026;
                case 36: goto L_0x0026;
                case 38: goto L_0x0026;
                case 40: goto L_0x0026;
                case 41: goto L_0x0026;
                case 47: goto L_0x0026;
                case 55: goto L_0x0026;
                case 57: goto L_0x0026;
                case 60: goto L_0x0026;
                case 64: goto L_0x0026;
                case 66: goto L_0x0026;
                case 67: goto L_0x0026;
                case 69: goto L_0x0026;
                case 72: goto L_0x0026;
                case 86: goto L_0x0026;
                case 87: goto L_0x0026;
                case 100: goto L_0x0026;
                case 101: goto L_0x0026;
                case 102: goto L_0x0026;
                case 103: goto L_0x0026;
                default: goto L_0x0025;
            }     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
        L_0x0025:
            goto L_0x0029
        L_0x0026:
            r6.Expression()     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
        L_0x0029:
            r4 = 78
            r6.m414F(r4)     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
            bsh.JJTParserState r4 = r6.f642a     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
            r4.mo804a(r0, r3)     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
            r6.mo983b(r0)     // Catch:{ Throwable -> 0x003d, all -> 0x0039 }
            r0.kind = r2     // Catch:{ Throwable -> 0x003d, all -> 0x0039 }
            return
        L_0x0039:
            r2 = move-exception
            r1 = r2
            r4 = 0
            goto L_0x0069
        L_0x003d:
            r2 = move-exception
            r4 = 0
            goto L_0x0045
        L_0x0040:
            r1 = move-exception
            r4 = 1
            goto L_0x0069
        L_0x0043:
            r2 = move-exception
            r4 = 1
        L_0x0045:
            if (r4 == 0) goto L_0x004f
            bsh.JJTParserState r5 = r6.f642a     // Catch:{ all -> 0x004d }
            r5.mo806b(r0)     // Catch:{ all -> 0x004d }
            goto L_0x0055
        L_0x004d:
            r1 = move-exception
            goto L_0x0069
        L_0x004f:
            bsh.JJTParserState r1 = r6.f642a     // Catch:{ all -> 0x004d }
            r1.mo807c()     // Catch:{ all -> 0x004d }
            r1 = r4
        L_0x0055:
            boolean r4 = r2 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0066 }
            if (r4 == 0) goto L_0x005c
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2     // Catch:{ all -> 0x0066 }
            throw r2     // Catch:{ all -> 0x0066 }
        L_0x005c:
            boolean r4 = r2 instanceof bsh.ParseException     // Catch:{ all -> 0x0066 }
            if (r4 == 0) goto L_0x0063
            bsh.ParseException r2 = (bsh.ParseException) r2     // Catch:{ all -> 0x0066 }
            throw r2     // Catch:{ all -> 0x0066 }
        L_0x0063:
            java.lang.Error r2 = (java.lang.Error) r2     // Catch:{ all -> 0x0066 }
            throw r2     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r2 = move-exception
            r4 = r1
            r1 = r2
        L_0x0069:
            if (r4 == 0) goto L_0x0073
            bsh.JJTParserState r2 = r6.f642a
            r2.mo804a(r0, r3)
            r6.mo983b(r0)
        L_0x0073:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.ReturnStatement():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ReturnType() {
        /*
            r6 = this;
            bsh.BSHReturnType r0 = new bsh.BSHReturnType
            r1 = 10
            r0.<init>(r1)
            bsh.JJTParserState r1 = r6.f642a
            r1.mo808c(r0)
            r6.mo980a(r0)
            r1 = 0
            r2 = 1
            int r3 = r6.f645d     // Catch:{ Throwable -> 0x0075, all -> 0x0072 }
            r4 = -1
            if (r3 != r4) goto L_0x001b
            int r3 = r6.m616dq()     // Catch:{ Throwable -> 0x0075, all -> 0x0072 }
            goto L_0x001d
        L_0x001b:
            int r3 = r6.f645d     // Catch:{ Throwable -> 0x0075, all -> 0x0072 }
        L_0x001d:
            r5 = 11
            if (r3 == r5) goto L_0x0063
            r5 = 14
            if (r3 == r5) goto L_0x0063
            r5 = 17
            if (r3 == r5) goto L_0x0063
            r5 = 22
            if (r3 == r5) goto L_0x0063
            r5 = 29
            if (r3 == r5) goto L_0x0063
            r5 = 36
            if (r3 == r5) goto L_0x0063
            r5 = 38
            if (r3 == r5) goto L_0x0063
            r5 = 47
            if (r3 == r5) goto L_0x0063
            r5 = 57
            if (r3 == r5) goto L_0x004e
            r5 = 69
            if (r3 == r5) goto L_0x0063
            r6.m414F(r4)     // Catch:{ Throwable -> 0x0075, all -> 0x0072 }
            bsh.ParseException r3 = new bsh.ParseException     // Catch:{ Throwable -> 0x0075, all -> 0x0072 }
            r3.<init>()     // Catch:{ Throwable -> 0x0075, all -> 0x0072 }
            throw r3     // Catch:{ Throwable -> 0x0075, all -> 0x0072 }
        L_0x004e:
            r6.m414F(r5)     // Catch:{ Throwable -> 0x0075, all -> 0x0072 }
            bsh.JJTParserState r3 = r6.f642a     // Catch:{ Throwable -> 0x0075, all -> 0x0072 }
            r3.mo804a(r0, r2)     // Catch:{ Throwable -> 0x0075, all -> 0x0072 }
            r6.mo983b(r0)     // Catch:{ Throwable -> 0x0060, all -> 0x005c }
            r0.isVoid = r2     // Catch:{ Throwable -> 0x0060, all -> 0x005c }
            goto L_0x0067
        L_0x005c:
            r3 = move-exception
            r1 = r3
            r4 = 0
            goto L_0x009b
        L_0x0060:
            r3 = move-exception
            r4 = 0
            goto L_0x0077
        L_0x0063:
            r6.Type()     // Catch:{ Throwable -> 0x0075, all -> 0x0072 }
            r1 = 1
        L_0x0067:
            if (r1 == 0) goto L_0x0071
            bsh.JJTParserState r1 = r6.f642a
            r1.mo804a(r0, r2)
            r6.mo983b(r0)
        L_0x0071:
            return
        L_0x0072:
            r1 = move-exception
            r4 = 1
            goto L_0x009b
        L_0x0075:
            r3 = move-exception
            r4 = 1
        L_0x0077:
            if (r4 == 0) goto L_0x0081
            bsh.JJTParserState r5 = r6.f642a     // Catch:{ all -> 0x007f }
            r5.mo806b(r0)     // Catch:{ all -> 0x007f }
            goto L_0x0087
        L_0x007f:
            r1 = move-exception
            goto L_0x009b
        L_0x0081:
            bsh.JJTParserState r1 = r6.f642a     // Catch:{ all -> 0x007f }
            r1.mo807c()     // Catch:{ all -> 0x007f }
            r1 = r4
        L_0x0087:
            boolean r4 = r3 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0098 }
            if (r4 == 0) goto L_0x008e
            java.lang.RuntimeException r3 = (java.lang.RuntimeException) r3     // Catch:{ all -> 0x0098 }
            throw r3     // Catch:{ all -> 0x0098 }
        L_0x008e:
            boolean r4 = r3 instanceof bsh.ParseException     // Catch:{ all -> 0x0098 }
            if (r4 == 0) goto L_0x0095
            bsh.ParseException r3 = (bsh.ParseException) r3     // Catch:{ all -> 0x0098 }
            throw r3     // Catch:{ all -> 0x0098 }
        L_0x0095:
            java.lang.Error r3 = (java.lang.Error) r3     // Catch:{ all -> 0x0098 }
            throw r3     // Catch:{ all -> 0x0098 }
        L_0x0098:
            r3 = move-exception
            r4 = r1
            r1 = r3
        L_0x009b:
            if (r4 == 0) goto L_0x00a5
            bsh.JJTParserState r3 = r6.f642a
            r3.mo804a(r0, r2)
            r6.mo983b(r0)
        L_0x00a5:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.ReturnType():void");
    }

    public final void ShiftExpression() {
        int i;
        AdditiveExpression();
        while (true) {
            switch (this.f645d == -1 ? m616dq() : this.f645d) {
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                    switch (this.f645d == -1 ? m616dq() : this.f645d) {
                        case 112:
                            i = 112;
                            break;
                        case 113:
                            i = 113;
                            break;
                        case 114:
                            i = 114;
                            break;
                        case 115:
                            i = 115;
                            break;
                        case 116:
                            i = 116;
                            break;
                        case 117:
                            i = 117;
                            break;
                        default:
                            m414F(-1);
                            throw new ParseException();
                    }
                    Token F = m414F(i);
                    AdditiveExpression();
                    BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(15);
                    boolean z = true;
                    this.f642a.mo808c(bSHBinaryExpression);
                    mo980a((Node) bSHBinaryExpression);
                    try {
                        this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                        z = false;
                        mo983b((Node) bSHBinaryExpression);
                        bSHBinaryExpression.kind = F.kind;
                    } catch (Throwable th) {
                        if (z) {
                            this.f642a.mo803a((Node) bSHBinaryExpression, 2);
                            mo983b((Node) bSHBinaryExpression);
                        }
                        throw th;
                    }
                default:
                    return;
            }
        }
    }

    public final void Statement() {
        if (m652v(2)) {
            LabeledStatement();
            return;
        }
        switch (this.f645d == -1 ? m616dq() : this.f645d) {
            case 11:
            case 14:
            case 17:
            case 22:
            case 26:
            case 29:
            case 36:
            case ParserConstants.LONG /*38*/:
            case ParserConstants.NEW /*40*/:
            case ParserConstants.NULL /*41*/:
            case 47:
            case 55:
            case 57:
            case ParserConstants.INTEGER_LITERAL /*60*/:
            case 64:
            case ParserConstants.CHARACTER_LITERAL /*66*/:
            case ParserConstants.STRING_LITERAL /*67*/:
            case ParserConstants.IDENTIFIER /*69*/:
            case ParserConstants.LPAREN /*72*/:
            case 86:
            case 87:
            case 100:
            case 101:
            case 102:
            case 103:
                StatementExpression();
                m414F(78);
                return;
            case 21:
                DoStatement();
                return;
            case 32:
                IfStatement();
                return;
            case 50:
                SwitchStatement();
                return;
            case ParserConstants.WHILE /*59*/:
                WhileStatement();
                return;
            case ParserConstants.LBRACE /*74*/:
                Block();
                return;
            case ParserConstants.SEMICOLON /*78*/:
                EmptyStatement();
                return;
            default:
                if (mo982a()) {
                    ForStatement();
                    return;
                }
                int dq = this.f645d == -1 ? m616dq() : this.f645d;
                if (dq == 12) {
                    BreakStatement();
                    return;
                } else if (dq == 19) {
                    ContinueStatement();
                    return;
                } else if (dq == 30) {
                    EnhancedForStatement();
                    return;
                } else if (dq == 46) {
                    ReturnStatement();
                    return;
                } else if (dq == 51) {
                    SynchronizedStatement();
                    return;
                } else if (dq == 53) {
                    ThrowStatement();
                    return;
                } else if (dq != 56) {
                    m414F(-1);
                    throw new ParseException();
                } else {
                    TryStatement();
                    return;
                }
        }
    }

    public final void StatementExpression() {
        Expression();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void StatementExpressionList() {
        /*
            r5 = this;
            bsh.BSHStatementExpressionList r0 = new bsh.BSHStatementExpressionList
            r1 = 34
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 1
            r5.StatementExpression()     // Catch:{ Throwable -> 0x0036 }
        L_0x0013:
            int r2 = r5.f645d     // Catch:{ Throwable -> 0x0036 }
            r3 = -1
            if (r2 != r3) goto L_0x001d
            int r2 = r5.m616dq()     // Catch:{ Throwable -> 0x0036 }
            goto L_0x001f
        L_0x001d:
            int r2 = r5.f645d     // Catch:{ Throwable -> 0x0036 }
        L_0x001f:
            r3 = 79
            if (r2 == r3) goto L_0x002c
            bsh.JJTParserState r2 = r5.f642a
            r2.mo804a(r0, r1)
            r5.mo983b(r0)
            return
        L_0x002c:
            r5.m414F(r3)     // Catch:{ Throwable -> 0x0036 }
            r5.StatementExpression()     // Catch:{ Throwable -> 0x0036 }
            goto L_0x0013
        L_0x0033:
            r2 = move-exception
            r3 = 1
            goto L_0x004f
        L_0x0036:
            r2 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x0033 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0033 }
            r3 = 0
            boolean r4 = r2 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x0044
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2     // Catch:{ all -> 0x004e }
            throw r2     // Catch:{ all -> 0x004e }
        L_0x0044:
            boolean r4 = r2 instanceof bsh.ParseException     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x004b
            bsh.ParseException r2 = (bsh.ParseException) r2     // Catch:{ all -> 0x004e }
            throw r2     // Catch:{ all -> 0x004e }
        L_0x004b:
            java.lang.Error r2 = (java.lang.Error) r2     // Catch:{ all -> 0x004e }
            throw r2     // Catch:{ all -> 0x004e }
        L_0x004e:
            r2 = move-exception
        L_0x004f:
            if (r3 == 0) goto L_0x0059
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r1)
            r5.mo983b(r0)
        L_0x0059:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.StatementExpressionList():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void SwitchLabel() {
        /*
            r7 = this;
            bsh.BSHSwitchLabel r0 = new bsh.BSHSwitchLabel
            r1 = 28
            r0.<init>(r1)
            bsh.JJTParserState r1 = r7.f642a
            r1.mo808c(r0)
            r7.mo980a(r0)
            r1 = 0
            r2 = 1
            int r3 = r7.f645d     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            r4 = -1
            if (r3 != r4) goto L_0x001b
            int r3 = r7.m616dq()     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            goto L_0x001d
        L_0x001b:
            int r3 = r7.f645d     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
        L_0x001d:
            r5 = 89
            r6 = 15
            if (r3 == r6) goto L_0x0048
            r6 = 20
            if (r3 == r6) goto L_0x0030
            r7.m414F(r4)     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            bsh.ParseException r3 = new bsh.ParseException     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            r3.<init>()     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            throw r3     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
        L_0x0030:
            r7.m414F(r6)     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            r7.m414F(r5)     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            bsh.JJTParserState r3 = r7.f642a     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            r3.mo804a(r0, r2)     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            r7.mo983b(r0)     // Catch:{ Throwable -> 0x0045, all -> 0x0041 }
            r0.f492a = r2     // Catch:{ Throwable -> 0x0045, all -> 0x0041 }
            goto L_0x0052
        L_0x0041:
            r3 = move-exception
            r1 = r3
            r4 = 0
            goto L_0x0086
        L_0x0045:
            r3 = move-exception
            r4 = 0
            goto L_0x0062
        L_0x0048:
            r7.m414F(r6)     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            r7.Expression()     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            r7.m414F(r5)     // Catch:{ Throwable -> 0x0060, all -> 0x005d }
            r1 = 1
        L_0x0052:
            if (r1 == 0) goto L_0x005c
            bsh.JJTParserState r1 = r7.f642a
            r1.mo804a(r0, r2)
            r7.mo983b(r0)
        L_0x005c:
            return
        L_0x005d:
            r1 = move-exception
            r4 = 1
            goto L_0x0086
        L_0x0060:
            r3 = move-exception
            r4 = 1
        L_0x0062:
            if (r4 == 0) goto L_0x006c
            bsh.JJTParserState r5 = r7.f642a     // Catch:{ all -> 0x006a }
            r5.mo806b(r0)     // Catch:{ all -> 0x006a }
            goto L_0x0072
        L_0x006a:
            r1 = move-exception
            goto L_0x0086
        L_0x006c:
            bsh.JJTParserState r1 = r7.f642a     // Catch:{ all -> 0x006a }
            r1.mo807c()     // Catch:{ all -> 0x006a }
            r1 = r4
        L_0x0072:
            boolean r4 = r3 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0083 }
            if (r4 == 0) goto L_0x0079
            java.lang.RuntimeException r3 = (java.lang.RuntimeException) r3     // Catch:{ all -> 0x0083 }
            throw r3     // Catch:{ all -> 0x0083 }
        L_0x0079:
            boolean r4 = r3 instanceof bsh.ParseException     // Catch:{ all -> 0x0083 }
            if (r4 == 0) goto L_0x0080
            bsh.ParseException r3 = (bsh.ParseException) r3     // Catch:{ all -> 0x0083 }
            throw r3     // Catch:{ all -> 0x0083 }
        L_0x0080:
            java.lang.Error r3 = (java.lang.Error) r3     // Catch:{ all -> 0x0083 }
            throw r3     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r3 = move-exception
            r4 = r1
            r1 = r3
        L_0x0086:
            if (r4 == 0) goto L_0x0090
            bsh.JJTParserState r3 = r7.f642a
            r3.mo804a(r0, r2)
            r7.mo983b(r0)
        L_0x0090:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.SwitchLabel():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void SwitchStatement() {
        /*
            r5 = this;
            bsh.BSHSwitchStatement r0 = new bsh.BSHSwitchStatement
            r1 = 27
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 50
            r2 = 1
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0059 }
            r1 = 72
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0059 }
            r5.Expression()     // Catch:{ Throwable -> 0x0059 }
            r1 = 73
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0059 }
            r1 = 74
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0059 }
        L_0x0027:
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0059 }
            r3 = -1
            if (r1 != r3) goto L_0x0031
            int r1 = r5.m616dq()     // Catch:{ Throwable -> 0x0059 }
            goto L_0x0033
        L_0x0031:
            int r1 = r5.f645d     // Catch:{ Throwable -> 0x0059 }
        L_0x0033:
            r3 = 15
            if (r1 == r3) goto L_0x0049
            r3 = 20
            if (r1 == r3) goto L_0x0049
            r1 = 75
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0059 }
            bsh.JJTParserState r1 = r5.f642a
            r1.mo804a(r0, r2)
            r5.mo983b(r0)
            return
        L_0x0049:
            r5.SwitchLabel()     // Catch:{ Throwable -> 0x0059 }
        L_0x004c:
            boolean r1 = r5.m409C(r2)     // Catch:{ Throwable -> 0x0059 }
            if (r1 == 0) goto L_0x0027
            r5.BlockStatement()     // Catch:{ Throwable -> 0x0059 }
            goto L_0x004c
        L_0x0056:
            r1 = move-exception
            r3 = 1
            goto L_0x0072
        L_0x0059:
            r1 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x0056 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0056 }
            r3 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0071 }
            if (r4 == 0) goto L_0x0067
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x0071 }
            throw r1     // Catch:{ all -> 0x0071 }
        L_0x0067:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x0071 }
            if (r4 == 0) goto L_0x006e
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x0071 }
            throw r1     // Catch:{ all -> 0x0071 }
        L_0x006e:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x0071 }
            throw r1     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r1 = move-exception
        L_0x0072:
            if (r3 == 0) goto L_0x007c
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r2)
            r5.mo983b(r0)
        L_0x007c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.SwitchStatement():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b A[SYNTHETIC, Splitter:B:13:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044 A[Catch:{ all -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004e A[Catch:{ all -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051 A[Catch:{ all -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void SynchronizedStatement() {
        /*
            r6 = this;
            bsh.BSHBlock r0 = new bsh.BSHBlock
            r1 = 25
            r0.<init>(r1)
            bsh.JJTParserState r1 = r6.f642a
            r1.mo808c(r0)
            r6.mo980a(r0)
            r1 = 51
            r2 = 0
            r3 = 1
            r6.m414F(r1)     // Catch:{ Throwable -> 0x0037, all -> 0x0034 }
            r1 = 72
            r6.m414F(r1)     // Catch:{ Throwable -> 0x0037, all -> 0x0034 }
            r6.Expression()     // Catch:{ Throwable -> 0x0037, all -> 0x0034 }
            r1 = 73
            r6.m414F(r1)     // Catch:{ Throwable -> 0x0037, all -> 0x0034 }
            r6.Block()     // Catch:{ Throwable -> 0x0037, all -> 0x0034 }
            bsh.JJTParserState r1 = r6.f642a     // Catch:{ Throwable -> 0x0037, all -> 0x0034 }
            r1.mo804a(r0, r3)     // Catch:{ Throwable -> 0x0037, all -> 0x0034 }
            r6.mo983b(r0)     // Catch:{ Throwable -> 0x0031 }
            r0.isSynchronized = r3     // Catch:{ Throwable -> 0x0031 }
            return
        L_0x0031:
            r1 = move-exception
            r4 = 0
            goto L_0x0039
        L_0x0034:
            r1 = move-exception
            r2 = 1
            goto L_0x005c
        L_0x0037:
            r1 = move-exception
            r4 = 1
        L_0x0039:
            if (r4 == 0) goto L_0x0044
            bsh.JJTParserState r5 = r6.f642a     // Catch:{ all -> 0x0041 }
            r5.mo806b(r0)     // Catch:{ all -> 0x0041 }
            goto L_0x004a
        L_0x0041:
            r1 = move-exception
            r2 = r4
            goto L_0x005c
        L_0x0044:
            bsh.JJTParserState r2 = r6.f642a     // Catch:{ all -> 0x0041 }
            r2.mo807c()     // Catch:{ all -> 0x0041 }
            r2 = r4
        L_0x004a:
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x005b }
            if (r4 == 0) goto L_0x0051
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x005b }
            throw r1     // Catch:{ all -> 0x005b }
        L_0x0051:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x005b }
            if (r4 == 0) goto L_0x0058
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x005b }
            throw r1     // Catch:{ all -> 0x005b }
        L_0x0058:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x005b }
            throw r1     // Catch:{ all -> 0x005b }
        L_0x005b:
            r1 = move-exception
        L_0x005c:
            if (r2 == 0) goto L_0x0066
            bsh.JJTParserState r2 = r6.f642a
            r2.mo804a(r0, r3)
            r6.mo983b(r0)
        L_0x0066:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.SynchronizedStatement():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ThrowStatement() {
        /*
            r5 = this;
            bsh.BSHThrowStatement r0 = new bsh.BSHThrowStatement
            r1 = 36
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 53
            r2 = 1
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0029 }
            r5.Expression()     // Catch:{ Throwable -> 0x0029 }
            r1 = 78
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0029 }
            bsh.JJTParserState r1 = r5.f642a
            r1.mo804a(r0, r2)
            r5.mo983b(r0)
            return
        L_0x0026:
            r1 = move-exception
            r3 = 1
            goto L_0x0042
        L_0x0029:
            r1 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x0026 }
            r3.mo806b(r0)     // Catch:{ all -> 0x0026 }
            r3 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0037
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x0041 }
            throw r1     // Catch:{ all -> 0x0041 }
        L_0x0037:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x003e
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x0041 }
            throw r1     // Catch:{ all -> 0x0041 }
        L_0x003e:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x0041 }
            throw r1     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r1 = move-exception
        L_0x0042:
            if (r3 == 0) goto L_0x004c
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r2)
            r5.mo983b(r0)
        L_0x004c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.ThrowStatement():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070 A[SYNTHETIC, Splitter:B:34:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0079 A[Catch:{ all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0083 A[Catch:{ all -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086 A[Catch:{ all -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void TryStatement() {
        /*
            r7 = this;
            bsh.BSHTryStatement r0 = new bsh.BSHTryStatement
            r1 = 37
            r0.<init>(r1)
            bsh.JJTParserState r1 = r7.f642a
            r1.mo808c(r0)
            r7.mo980a(r0)
            r1 = 56
            r2 = 0
            r3 = 1
            r7.m414F(r1)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r7.Block()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r1 = 0
        L_0x001a:
            int r4 = r7.f645d     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r5 = -1
            if (r4 != r5) goto L_0x0024
            int r4 = r7.m616dq()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            goto L_0x0026
        L_0x0024:
            int r4 = r7.f645d     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
        L_0x0026:
            r6 = 16
            if (r4 == r6) goto L_0x0054
            int r4 = r7.f645d     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            if (r4 != r5) goto L_0x0033
            int r4 = r7.m616dq()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            goto L_0x0035
        L_0x0033:
            int r4 = r7.f645d     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
        L_0x0035:
            r5 = 28
            if (r4 == r5) goto L_0x003a
            goto L_0x0041
        L_0x003a:
            r7.m414F(r5)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r7.Block()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r1 = 1
        L_0x0041:
            bsh.JJTParserState r4 = r7.f642a     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r4.mo804a(r0, r3)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r7.mo983b(r0)     // Catch:{ Throwable -> 0x0051 }
            if (r1 != 0) goto L_0x0050
            bsh.ParseException r1 = r7.generateParseException()     // Catch:{ Throwable -> 0x0051 }
            throw r1     // Catch:{ Throwable -> 0x0051 }
        L_0x0050:
            return
        L_0x0051:
            r1 = move-exception
            r4 = 0
            goto L_0x006e
        L_0x0054:
            r7.m414F(r6)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r1 = 72
            r7.m414F(r1)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r7.FormalParameter()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r1 = 73
            r7.m414F(r1)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r7.Block()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r1 = 1
            goto L_0x001a
        L_0x0069:
            r1 = move-exception
            r2 = 1
            goto L_0x0091
        L_0x006c:
            r1 = move-exception
            r4 = 1
        L_0x006e:
            if (r4 == 0) goto L_0x0079
            bsh.JJTParserState r5 = r7.f642a     // Catch:{ all -> 0x0076 }
            r5.mo806b(r0)     // Catch:{ all -> 0x0076 }
            goto L_0x007f
        L_0x0076:
            r1 = move-exception
            r2 = r4
            goto L_0x0091
        L_0x0079:
            bsh.JJTParserState r2 = r7.f642a     // Catch:{ all -> 0x0076 }
            r2.mo807c()     // Catch:{ all -> 0x0076 }
            r2 = r4
        L_0x007f:
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0090 }
            if (r4 == 0) goto L_0x0086
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x0090 }
            throw r1     // Catch:{ all -> 0x0090 }
        L_0x0086:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x0090 }
            if (r4 == 0) goto L_0x008d
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x0090 }
            throw r1     // Catch:{ all -> 0x0090 }
        L_0x008d:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x0090 }
            throw r1     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r1 = move-exception
        L_0x0091:
            if (r2 == 0) goto L_0x009b
            bsh.JJTParserState r2 = r7.f642a
            r2.mo804a(r0, r3)
            r7.mo983b(r0)
        L_0x009b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.TryStatement():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Type() {
        /*
            r5 = this;
            bsh.BSHType r0 = new bsh.BSHType
            r1 = 9
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 1
            int r2 = r5.f645d     // Catch:{ Throwable -> 0x0071 }
            r3 = -1
            if (r2 != r3) goto L_0x001a
            int r2 = r5.m616dq()     // Catch:{ Throwable -> 0x0071 }
            goto L_0x001c
        L_0x001a:
            int r2 = r5.f645d     // Catch:{ Throwable -> 0x0071 }
        L_0x001c:
            r4 = 11
            if (r2 == r4) goto L_0x004d
            r4 = 14
            if (r2 == r4) goto L_0x004d
            r4 = 17
            if (r2 == r4) goto L_0x004d
            r4 = 22
            if (r2 == r4) goto L_0x004d
            r4 = 29
            if (r2 == r4) goto L_0x004d
            r4 = 36
            if (r2 == r4) goto L_0x004d
            r4 = 38
            if (r2 == r4) goto L_0x004d
            r4 = 47
            if (r2 == r4) goto L_0x004d
            r4 = 69
            if (r2 == r4) goto L_0x0049
            r5.m414F(r3)     // Catch:{ Throwable -> 0x0071 }
            bsh.ParseException r2 = new bsh.ParseException     // Catch:{ Throwable -> 0x0071 }
            r2.<init>()     // Catch:{ Throwable -> 0x0071 }
            throw r2     // Catch:{ Throwable -> 0x0071 }
        L_0x0049:
            r5.AmbiguousName()     // Catch:{ Throwable -> 0x0071 }
            goto L_0x0050
        L_0x004d:
            r5.PrimitiveType()     // Catch:{ Throwable -> 0x0071 }
        L_0x0050:
            r2 = 2
            boolean r2 = r5.m620f(r2)     // Catch:{ Throwable -> 0x0071 }
            if (r2 == 0) goto L_0x0065
            r2 = 76
            r5.m414F(r2)     // Catch:{ Throwable -> 0x0071 }
            r2 = 77
            r5.m414F(r2)     // Catch:{ Throwable -> 0x0071 }
            r0.addArrayDimension()     // Catch:{ Throwable -> 0x0071 }
            goto L_0x0050
        L_0x0065:
            bsh.JJTParserState r2 = r5.f642a
            r2.mo804a(r0, r1)
            r5.mo983b(r0)
            return
        L_0x006e:
            r2 = move-exception
            r3 = 1
            goto L_0x008a
        L_0x0071:
            r2 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x006e }
            r3.mo806b(r0)     // Catch:{ all -> 0x006e }
            r3 = 0
            boolean r4 = r2 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x007f
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2     // Catch:{ all -> 0x0089 }
            throw r2     // Catch:{ all -> 0x0089 }
        L_0x007f:
            boolean r4 = r2 instanceof bsh.ParseException     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x0086
            bsh.ParseException r2 = (bsh.ParseException) r2     // Catch:{ all -> 0x0089 }
            throw r2     // Catch:{ all -> 0x0089 }
        L_0x0086:
            java.lang.Error r2 = (java.lang.Error) r2     // Catch:{ all -> 0x0089 }
            throw r2     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r2 = move-exception
        L_0x008a:
            if (r3 == 0) goto L_0x0094
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r1)
            r5.mo983b(r0)
        L_0x0094:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.Type():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void TypedVariableDeclaration() {
        /*
            r6 = this;
            bsh.BSHTypedVariableDeclaration r0 = new bsh.BSHTypedVariableDeclaration
            r1 = 33
            r0.<init>(r1)
            bsh.JJTParserState r1 = r6.f642a
            r1.mo808c(r0)
            r6.mo980a(r0)
            r1 = 2
            r2 = 0
            r3 = 1
            bsh.Modifiers r1 = r6.Modifiers(r1, r2)     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            r6.Type()     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
        L_0x0019:
            r6.VariableDeclarator()     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            int r4 = r6.f645d     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            r5 = -1
            if (r4 != r5) goto L_0x0026
            int r4 = r6.m616dq()     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            goto L_0x0028
        L_0x0026:
            int r4 = r6.f645d     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
        L_0x0028:
            r5 = 79
            if (r4 == r5) goto L_0x003a
            bsh.JJTParserState r4 = r6.f642a     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            r4.mo804a(r0, r3)     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            r6.mo983b(r0)     // Catch:{ Throwable -> 0x0037 }
            r0.modifiers = r1     // Catch:{ Throwable -> 0x0037 }
            return
        L_0x0037:
            r1 = move-exception
            r4 = 0
            goto L_0x0043
        L_0x003a:
            r6.m414F(r5)     // Catch:{ Throwable -> 0x0041, all -> 0x003e }
            goto L_0x0019
        L_0x003e:
            r1 = move-exception
            r2 = 1
            goto L_0x0066
        L_0x0041:
            r1 = move-exception
            r4 = 1
        L_0x0043:
            if (r4 == 0) goto L_0x004e
            bsh.JJTParserState r5 = r6.f642a     // Catch:{ all -> 0x004b }
            r5.mo806b(r0)     // Catch:{ all -> 0x004b }
            goto L_0x0054
        L_0x004b:
            r1 = move-exception
            r2 = r4
            goto L_0x0066
        L_0x004e:
            bsh.JJTParserState r2 = r6.f642a     // Catch:{ all -> 0x004b }
            r2.mo807c()     // Catch:{ all -> 0x004b }
            r2 = r4
        L_0x0054:
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0065 }
            if (r4 == 0) goto L_0x005b
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x0065 }
            throw r1     // Catch:{ all -> 0x0065 }
        L_0x005b:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x0065 }
            if (r4 == 0) goto L_0x0062
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x0065 }
            throw r1     // Catch:{ all -> 0x0065 }
        L_0x0062:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x0065 }
            throw r1     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r1 = move-exception
        L_0x0066:
            if (r2 == 0) goto L_0x0070
            bsh.JJTParserState r2 = r6.f642a
            r2.mo804a(r0, r3)
            r6.mo983b(r0)
        L_0x0070:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.TypedVariableDeclaration():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void UnaryExpression() {
        /*
            r4 = this;
            int r0 = r4.f645d
            r1 = -1
            if (r0 != r1) goto L_0x000a
            int r0 = r4.m616dq()
            goto L_0x000c
        L_0x000a:
            int r0 = r4.f645d
        L_0x000c:
            switch(r0) {
                case 11: goto L_0x0070;
                case 14: goto L_0x0070;
                case 17: goto L_0x0070;
                case 22: goto L_0x0070;
                case 26: goto L_0x0070;
                case 29: goto L_0x0070;
                case 36: goto L_0x0070;
                case 38: goto L_0x0070;
                case 40: goto L_0x0070;
                case 41: goto L_0x0070;
                case 47: goto L_0x0070;
                case 55: goto L_0x0070;
                case 57: goto L_0x0070;
                case 60: goto L_0x0070;
                case 64: goto L_0x0070;
                case 66: goto L_0x0070;
                case 67: goto L_0x0070;
                case 69: goto L_0x0070;
                case 72: goto L_0x0070;
                case 86: goto L_0x0070;
                case 87: goto L_0x0070;
                case 100: goto L_0x006c;
                case 101: goto L_0x0068;
                case 102: goto L_0x0018;
                case 103: goto L_0x0018;
                default: goto L_0x000f;
            }
        L_0x000f:
            r4.m414F(r1)
            bsh.ParseException r0 = new bsh.ParseException
            r0.<init>()
            throw r0
        L_0x0018:
            int r0 = r4.f645d
            if (r0 != r1) goto L_0x0021
            int r0 = r4.m616dq()
            goto L_0x0023
        L_0x0021:
            int r0 = r4.f645d
        L_0x0023:
            switch(r0) {
                case 102: goto L_0x0032;
                case 103: goto L_0x002f;
                default: goto L_0x0026;
            }
        L_0x0026:
            r4.m414F(r1)
            bsh.ParseException r0 = new bsh.ParseException
            r0.<init>()
            throw r0
        L_0x002f:
            r0 = 103(0x67, float:1.44E-43)
            goto L_0x0034
        L_0x0032:
            r0 = 102(0x66, float:1.43E-43)
        L_0x0034:
            bsh.Token r0 = r4.m414F(r0)
            r4.UnaryExpression()
            bsh.BSHUnaryExpression r1 = new bsh.BSHUnaryExpression
            r2 = 16
            r1.<init>(r2)
            bsh.JJTParserState r2 = r4.f642a
            r2.mo808c(r1)
            r4.mo980a(r1)
            r2 = 1
            bsh.JJTParserState r3 = r4.f642a     // Catch:{ all -> 0x005b }
            r3.mo803a(r1, r2)     // Catch:{ all -> 0x005b }
            r3 = 0
            r4.mo983b(r1)     // Catch:{ all -> 0x0059 }
            int r0 = r0.kind     // Catch:{ all -> 0x0059 }
            r1.kind = r0     // Catch:{ all -> 0x0059 }
            return
        L_0x0059:
            r0 = move-exception
            goto L_0x005d
        L_0x005b:
            r0 = move-exception
            r3 = 1
        L_0x005d:
            if (r3 == 0) goto L_0x0067
            bsh.JJTParserState r3 = r4.f642a
            r3.mo803a(r1, r2)
            r4.mo983b(r1)
        L_0x0067:
            throw r0
        L_0x0068:
            r4.PreDecrementExpression()
            return
        L_0x006c:
            r4.PreIncrementExpression()
            return
        L_0x0070:
            r4.UnaryExpressionNotPlusMinus()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.UnaryExpression():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void UnaryExpressionNotPlusMinus() {
        /*
            r4 = this;
            int r0 = r4.f645d
            r1 = -1
            if (r0 != r1) goto L_0x000a
            int r0 = r4.m616dq()
            goto L_0x000c
        L_0x000a:
            int r0 = r4.f645d
        L_0x000c:
            switch(r0) {
                case 86: goto L_0x001c;
                case 87: goto L_0x001c;
                default: goto L_0x000f;
            }
        L_0x000f:
            r0 = 2147483647(0x7fffffff, float:NaN)
            boolean r0 = r4.m626i(r0)
            if (r0 == 0) goto L_0x006c
            r4.CastExpression()
            return
        L_0x001c:
            int r0 = r4.f645d
            if (r0 != r1) goto L_0x0025
            int r0 = r4.m616dq()
            goto L_0x0027
        L_0x0025:
            int r0 = r4.f645d
        L_0x0027:
            switch(r0) {
                case 86: goto L_0x0036;
                case 87: goto L_0x0033;
                default: goto L_0x002a;
            }
        L_0x002a:
            r4.m414F(r1)
            bsh.ParseException r0 = new bsh.ParseException
            r0.<init>()
            throw r0
        L_0x0033:
            r0 = 87
            goto L_0x0038
        L_0x0036:
            r0 = 86
        L_0x0038:
            bsh.Token r0 = r4.m414F(r0)
            r4.UnaryExpression()
            bsh.BSHUnaryExpression r1 = new bsh.BSHUnaryExpression
            r2 = 16
            r1.<init>(r2)
            bsh.JJTParserState r2 = r4.f642a
            r2.mo808c(r1)
            r4.mo980a(r1)
            r2 = 1
            bsh.JJTParserState r3 = r4.f642a     // Catch:{ all -> 0x005f }
            r3.mo803a(r1, r2)     // Catch:{ all -> 0x005f }
            r3 = 0
            r4.mo983b(r1)     // Catch:{ all -> 0x005d }
            int r0 = r0.kind     // Catch:{ all -> 0x005d }
            r1.kind = r0     // Catch:{ all -> 0x005d }
            return
        L_0x005d:
            r0 = move-exception
            goto L_0x0061
        L_0x005f:
            r0 = move-exception
            r3 = 1
        L_0x0061:
            if (r3 == 0) goto L_0x006b
            bsh.JJTParserState r3 = r4.f642a
            r3.mo803a(r1, r2)
            r4.mo983b(r1)
        L_0x006b:
            throw r0
        L_0x006c:
            int r0 = r4.f645d
            if (r0 != r1) goto L_0x0075
            int r0 = r4.m616dq()
            goto L_0x0077
        L_0x0075:
            int r0 = r4.f645d
        L_0x0077:
            switch(r0) {
                case 11: goto L_0x0083;
                case 14: goto L_0x0083;
                case 17: goto L_0x0083;
                case 22: goto L_0x0083;
                case 26: goto L_0x0083;
                case 29: goto L_0x0083;
                case 36: goto L_0x0083;
                case 38: goto L_0x0083;
                case 40: goto L_0x0083;
                case 41: goto L_0x0083;
                case 47: goto L_0x0083;
                case 55: goto L_0x0083;
                case 57: goto L_0x0083;
                case 60: goto L_0x0083;
                case 64: goto L_0x0083;
                case 66: goto L_0x0083;
                case 67: goto L_0x0083;
                case 69: goto L_0x0083;
                case 72: goto L_0x0083;
                default: goto L_0x007a;
            }
        L_0x007a:
            r4.m414F(r1)
            bsh.ParseException r0 = new bsh.ParseException
            r0.<init>()
            throw r0
        L_0x0083:
            r4.PostfixExpression()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.UnaryExpressionNotPlusMinus():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC, Splitter:B:21:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A[Catch:{ all -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057 A[Catch:{ all -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005a A[Catch:{ all -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void VariableDeclarator() {
        /*
            r6 = this;
            bsh.BSHVariableDeclarator r0 = new bsh.BSHVariableDeclarator
            r1 = 5
            r0.<init>(r1)
            bsh.JJTParserState r1 = r6.f642a
            r1.mo808c(r0)
            r6.mo980a(r0)
            r1 = 69
            r2 = 0
            r3 = 1
            bsh.Token r1 = r6.m414F(r1)     // Catch:{ Throwable -> 0x0040, all -> 0x003d }
            int r4 = r6.f645d     // Catch:{ Throwable -> 0x0040, all -> 0x003d }
            r5 = -1
            if (r4 != r5) goto L_0x0020
            int r4 = r6.m616dq()     // Catch:{ Throwable -> 0x0040, all -> 0x003d }
            goto L_0x0022
        L_0x0020:
            int r4 = r6.f645d     // Catch:{ Throwable -> 0x0040, all -> 0x003d }
        L_0x0022:
            r5 = 81
            if (r4 == r5) goto L_0x0027
            goto L_0x002d
        L_0x0027:
            r6.m414F(r5)     // Catch:{ Throwable -> 0x0040, all -> 0x003d }
            r6.VariableInitializer()     // Catch:{ Throwable -> 0x0040, all -> 0x003d }
        L_0x002d:
            bsh.JJTParserState r4 = r6.f642a     // Catch:{ Throwable -> 0x0040, all -> 0x003d }
            r4.mo804a(r0, r3)     // Catch:{ Throwable -> 0x0040, all -> 0x003d }
            r6.mo983b(r0)     // Catch:{ Throwable -> 0x003a }
            java.lang.String r1 = r1.image     // Catch:{ Throwable -> 0x003a }
            r0.name = r1     // Catch:{ Throwable -> 0x003a }
            return
        L_0x003a:
            r1 = move-exception
            r4 = 0
            goto L_0x0042
        L_0x003d:
            r1 = move-exception
            r2 = 1
            goto L_0x0065
        L_0x0040:
            r1 = move-exception
            r4 = 1
        L_0x0042:
            if (r4 == 0) goto L_0x004d
            bsh.JJTParserState r5 = r6.f642a     // Catch:{ all -> 0x004a }
            r5.mo806b(r0)     // Catch:{ all -> 0x004a }
            goto L_0x0053
        L_0x004a:
            r1 = move-exception
            r2 = r4
            goto L_0x0065
        L_0x004d:
            bsh.JJTParserState r2 = r6.f642a     // Catch:{ all -> 0x004a }
            r2.mo807c()     // Catch:{ all -> 0x004a }
            r2 = r4
        L_0x0053:
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x005a
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x0064 }
            throw r1     // Catch:{ all -> 0x0064 }
        L_0x005a:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0061
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x0064 }
            throw r1     // Catch:{ all -> 0x0064 }
        L_0x0061:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x0064 }
            throw r1     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r1 = move-exception
        L_0x0065:
            if (r2 == 0) goto L_0x006f
            bsh.JJTParserState r2 = r6.f642a
            r2.mo804a(r0, r3)
            r6.mo983b(r0)
        L_0x006f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.VariableDeclarator():void");
    }

    public final void VariableInitializer() {
        switch (this.f645d == -1 ? m616dq() : this.f645d) {
            case 11:
            case 14:
            case 17:
            case 22:
            case 26:
            case 29:
            case 36:
            case ParserConstants.LONG /*38*/:
            case ParserConstants.NEW /*40*/:
            case ParserConstants.NULL /*41*/:
            case 47:
            case 55:
            case 57:
            case ParserConstants.INTEGER_LITERAL /*60*/:
            case 64:
            case ParserConstants.CHARACTER_LITERAL /*66*/:
            case ParserConstants.STRING_LITERAL /*67*/:
            case ParserConstants.IDENTIFIER /*69*/:
            case ParserConstants.LPAREN /*72*/:
            case 86:
            case 87:
            case 100:
            case 101:
            case 102:
            case 103:
                Expression();
                return;
            case ParserConstants.LBRACE /*74*/:
                ArrayInitializer();
                return;
            default:
                m414F(-1);
                throw new ParseException();
        }
    }

    public final void VoidLiteral() {
        m414F(57);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void WhileStatement() {
        /*
            r5 = this;
            bsh.BSHWhileStatement r0 = new bsh.BSHWhileStatement
            r1 = 30
            r0.<init>(r1)
            bsh.JJTParserState r1 = r5.f642a
            r1.mo808c(r0)
            r5.mo980a(r0)
            r1 = 59
            r2 = 1
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0031 }
            r1 = 72
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0031 }
            r5.Expression()     // Catch:{ Throwable -> 0x0031 }
            r1 = 73
            r5.m414F(r1)     // Catch:{ Throwable -> 0x0031 }
            r5.Statement()     // Catch:{ Throwable -> 0x0031 }
            bsh.JJTParserState r1 = r5.f642a
            r1.mo804a(r0, r2)
            r5.mo983b(r0)
            return
        L_0x002e:
            r1 = move-exception
            r3 = 1
            goto L_0x004a
        L_0x0031:
            r1 = move-exception
            bsh.JJTParserState r3 = r5.f642a     // Catch:{ all -> 0x002e }
            r3.mo806b(r0)     // Catch:{ all -> 0x002e }
            r3 = 0
            boolean r4 = r1 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0049 }
            if (r4 == 0) goto L_0x003f
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch:{ all -> 0x0049 }
            throw r1     // Catch:{ all -> 0x0049 }
        L_0x003f:
            boolean r4 = r1 instanceof bsh.ParseException     // Catch:{ all -> 0x0049 }
            if (r4 == 0) goto L_0x0046
            bsh.ParseException r1 = (bsh.ParseException) r1     // Catch:{ all -> 0x0049 }
            throw r1     // Catch:{ all -> 0x0049 }
        L_0x0046:
            java.lang.Error r1 = (java.lang.Error) r1     // Catch:{ all -> 0x0049 }
            throw r1     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r1 = move-exception
        L_0x004a:
            if (r3 == 0) goto L_0x0054
            bsh.JJTParserState r3 = r5.f642a
            r3.mo804a(r0, r2)
            r5.mo983b(r0)
        L_0x0054:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Parser.WhileStatement():void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ParseException mo979a(String str) {
        Token token2 = this.token;
        int i = token2.beginLine;
        int i2 = token2.beginColumn;
        if (token2.kind == 0) {
            String str2 = ParserConstants.tokenImage[0];
        } else {
            String str3 = token2.image;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Parse error at line ");
        stringBuffer.append(i);
        stringBuffer.append(", column ");
        stringBuffer.append(i2);
        stringBuffer.append(" : ");
        stringBuffer.append(str);
        return new ParseException(stringBuffer.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo980a(Node node) {
        ((SimpleNode) node).f696j = getToken(1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo981a(Reader reader) {
        ReInit(reader);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo982a() {
        if (getToken(1).kind != 30) {
            return false;
        }
        int i = 3;
        if (getToken(2).kind != 72) {
            return false;
        }
        while (true) {
            int i2 = i + 1;
            int i3 = getToken(i).kind;
            if (i3 == 0) {
                return false;
            }
            if (i3 == 78) {
                return true;
            }
            if (i3 == 89) {
                return false;
            }
            i = i2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo983b(Node node) {
        ((SimpleNode) node).f697k = getToken(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo984b(Reader reader) {
        this.f644c.ReInit(reader, this.f644c.getEndLine(), this.f644c.getEndColumn());
    }

    public final void disable_tracing() {
    }

    public final void enable_tracing() {
    }

    public ParseException generateParseException() {
        Token token2 = this.token.next;
        int i = token2.beginLine;
        int i2 = token2.beginColumn;
        String str = token2.kind == 0 ? ParserConstants.tokenImage[0] : token2.image;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Parse error at line ");
        stringBuffer.append(i);
        stringBuffer.append(", column ");
        stringBuffer.append(i2);
        stringBuffer.append(".  Encountered: ");
        stringBuffer.append(str);
        return new ParseException(stringBuffer.toString());
    }

    public final Token getNextToken() {
        if (this.token.next != null) {
            this.token = this.token.next;
        } else {
            Token token2 = this.token;
            Token nextToken = this.token_source.getNextToken();
            token2.next = nextToken;
            this.token = nextToken;
        }
        this.f645d = -1;
        return this.token;
    }

    public final Token getToken(int i) {
        Token token2;
        Token token3 = this.lookingAhead ? this.f646e : this.token;
        for (int i2 = 0; i2 < i; i2++) {
            if (token3.next != null) {
                token2 = token3.next;
            } else {
                Token nextToken = this.token_source.getNextToken();
                token3.next = nextToken;
                token2 = nextToken;
            }
        }
        return token3;
    }

    public SimpleNode popNode() {
        if (this.f642a.mo809d() > 0) {
            return (SimpleNode) this.f642a.mo807c();
        }
        return null;
    }

    public void setRetainComments(boolean z) {
        this.f643b = z;
    }
}
