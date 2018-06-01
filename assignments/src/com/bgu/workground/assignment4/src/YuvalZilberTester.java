package com.bgu.workground.assignment4.src;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.Arrays;
public class YuvalZilberTester{
    private static void printTree(String treeLayout) {
        String strTree = treeLayout;//toString();
        String[] treeLevels = strTree.split("#");
        for (int i = 0; i < treeLevels.length; i++) {
            String[] level = treeLevels[i].split("\\|");
            for (int j = 0; j < Math.pow(2, treeLevels.length - i); j++)
                System.out.print("  ");
            for (int k = 0; k < level.length; k++) {
                if (level[k].contains("^")) {
                    String[] level2 = level[k].split("\\^");
                    System.out.print("[" + level2[0] + "]");
                    for (int j = 0; j < Math.pow(3, treeLevels.length - i); j++)
                        System.out.print("_");
                    System.out.print("[" + level2[1] + "]");
                } else
                    System.out.print("[" + level[k] + "]");
                for (int j = 0; j < Math.pow(2, treeLevels.length - i); j++)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        System.out.println("intro:");
        System.out.println("hey, this is yuval zilber, i wrote this tester for 1 reason - to help you");
        System.out.println("if you have any question about this assignment - contact me.");
        System.out.println("if you need any help in this course - i'm here and i will be glad to help you");
        System.out.println("i'm available in whatsapp/sms - 0504840490");
        System.out.println("i'm available in FaceBook - Yuval Zilber");
        System.out.println("Tests Legend : ");
        System.out.println("TEST 1 - a standard check for BTree creation and toString(), for t from 2 to 10 and random friends pairs");
        System.out.println("TEST 2 - check you 'contains' method, insert 1,000 random values to your tree from 0 to 100,000");
        System.out.println("         and check for any number in the range 0-100,000 if the number is in the tree or not");
        System.out.println("TEST 3 - check your exceptions for wrong input to t parameter");
        System.out.println("TEST 4 - a standard check for spam detection, see messages0.txt file for more information");
        System.out.println("TEST 5 - what you do for am empty spam_words file?");
        System.out.println("TEST 6 - what you do for am empty messages file?");
        System.out.println("TEST 7 - what you do for am 1 message in messages file?");
        System.out.println("TEST 8 - check your exceptions for wrong input to m parameter");
        System.out.println("------------------------START------------------------");
        String[] results_test1=new String[11];
        results_test1[1]="";
        results_test1[2]="NL & HLdL,cWRe & xcd#FqxnHY & cWlY|VZi & QzPlYeHpf|nvshwWgsN & jDzjJwGps#CZSabE & B|IIc & ibMEzPiL,KTmMLnqU & CottThHr^RRpH & XnnmTk|bOcVfzCA & NYAsU^htYo & LgyVoInEV|t & pWhYtAKz,umpxo & UGCbCpqy#Bgv & RAqxe|DkkLpySUS & JoK,EsJVsRrdMJ & XwS^Hhh & DY|JUP & L|MAYjPaB & mlgM^OOURJmq & fnDDb|T & qZozAT^Wx & B,Zr & GsyODW|c & lqjuFqjjAC^f & sAYTzS|mMKVI & xnHCJjSAk,mdj & qbWhylWj^polROq & soLSCqu,rMcRlDy & coZ,sTP & YxyIWW|uTtmFI & zegx|xk & GDWSaHgQ#AdJeF & eb,AgLSgTaWOr & CDJhxm,BJxkBZr & n|BhdhSrQU & ojdt,COIRltRg & NtDBYGwBuL^CvlCA & yRHSobgyu,DQH & upGhRS,Ddo & ksAtx|DpV & VEC,E & vRuq|Fq & MMDAJ^GrTiHOhr & wEMQy,GwWPhqdG & EsQntn|HjpMi & fYGHglpO^IY & tXEre,JG & oYjLaQ|K & jHsTrlnRY,KMEwF & rBQtRxoNxp^KbGwWe & bMB,LUjrCILj & AgUUMfikN,LZwzkp & oncPf|MXHB & x^NjyFNNne & vFaxy,OBDsYkU & ZE,OMMKQmO & aDgOYMUT|PExKsXf & AoKOOG^Rxo & QaSVhAwKA|TPDl & ufTKWFgaM,Tr & nFQ,VFmhz & JiUs^VseQupD & csl|XW & lUgkFResa,Xupjvxec & B|aFbyUarQGn & MgL,aUykqpA & yaXrnycYDe^bzFOVY & vcm|cDvyWy & fGC,cWHjr & xcfpUYzn^cgDkJbWEzD & AWZCUhUMi,duZtCCXQqC & EIrKhfbDO,eamGF & dqy|gfjRDKLHGR & rvFR,gpjlyqEM & EmnLTH,gtDppzdY & gTNorJ^ib & kJkn,kWg & FzIyFRw,lt & unFdKsU|mQTR & BXgORq,mUKiwHKDw & lE|n & LjpqNM^ojwOIEKL & kUMZIGwam,pEneYhgLB & dCtbUmm,pFoS & HMq|qGkZjJM & fQKtwtGMb,qcHuVrcupM & wfJYWyU,rKrqAooUC & rTI|sOB & bdd,sSoqh & ZUCELslWCq|t & iUiqrB^tbkPdWVq & oAMDk,txMMj & LsBNSLaus,uQqZmjSRlY & ClIWpqoCP|ubE & rkdP^vurGuydeJ & RJQOSW,xGFtEqYsp & bumxcNZYt|y & bCjJ,yXvisM & qIiLBZzzM,yY & PkItwVWNYj";
        results_test1[3]="YyVS & HAelgmxzMA#LsE & Zbex,SJEw & LPiWg|jhHmUwAH & ponr,vVNCAK & EFpatZf#C & quBXJZEq,GGCD & Oc,IcYcnMEiwx & VBKHG,K & KORTyXwUY|PPdEBc & WrAAggq,RYh & Zoub|T & XKsLKHL,VIIU & ikmuhHTfm,Won & vMBio^b & aZqSFyxufJ,cdVWCFONFo & GsXGzwzd,dmeIBREw & jheX,hO & bSNRJEGMAk|mwaZ & rQtaBQzwE,owgLP & mrqG|wpQYZlFUuE & i,zHjbsxpNj & IDXGNR#BWoc & YeWZBTe,Bchvg & KlzMg,BqTUjhbnDg & Ykmgh,ByoXBxdqP & dsNabfdlJ|CBlIhZiF & hmbSI,DAtBBjftLj & ZJuuFFXzrT,FAJQRBvwO & kgapkzUx,FFvZltRQ & eAJnJx,FRYbFDpiPZ & Nxd|GzCD & PDS,HBU & qvxa,HJHf & ysu,HTRMKJRLda & pAqhgB,HpPgVKTP & idjoEe|JaiQ & uMmseexsGt,JflGODZC & UmKf|Kydk & khwV,LpccjDoRYM & Ar^MAExAgup & Zn,Mcxcc & ipolA,MgYKPY & MJHdOrjZf,NwdbUT & dhn,OmuFWBWQte & WIm|PnxeNwZq & IQHlJY,PxtEFUV & kOZJOfoUo,PzLMNJ & ZqrMEQTx,RDh & cBURGInr|RsUwQkPj & P,S & uiVftt^SSPmi & oETDzRG,SjQKabssa & WyxYjhW,T & DxBHspNvwh|TjQ & NTgE,TzpHNC & MPaZEGw,UKJdqdE & RIGP,UjHUYASBa & DUMzWFgF|VfSZSec & a,VrqQYAmQ & BXCeWDngG|XWDxNdQ & sNOgsCMN,YFzikszUY & qVjcB,YNjjuhJjZg & DFeeYuhdHB,YtH & eNzZaNkga^ZV & swrBgHE,ZzZwnrL & ZyfTLOPo,aAHpi & mwdV|bsfrI & AYVuZZuc,cYZjArZaq & bdhr|dTr & UouJ,dhIIuUN & Vw|e & IzOjM,efjo & iGMQmJ,fWOqcQWSr & j,gaqC & nRIn|ijDkDH & bybp,jWktlJxjf & LeNhWdw^kBY & UPxTCpfa,kIteAsqix & GOeMnNog,kZYCpQDXLi & w,lnSzXVrp & zdNPKDfB,mHF & n|ncGZhKGdV & pM,oHLQBtsiu & xvQVeefQ,oVaf & XdRKAsJ,oXSi & zbQivplpDc|tYzKN & Im,tgxrbiZQ & D,vDUHiTwTFa & b,vJT & qvKCGPn,vOvSAcqlb & AfhTcf^vgNKnmesX & M,wOTSUPvv & tFBkmJMdQx|wu & aDwfyl,xNXl & PcNrca,xQfx & ZYc,yia & SAVFE,yyOE & y|zlSqNeHzv & YePrppG,zq & YsNTERU";
        results_test1[4]="QgqT & Fw,bTMShu & vnJqCqIB,nRtkzsW & MZIekVVP#CbHt & tAfaq,HPRDtVuRSy & FwRltCf,IYfySRZnr & StVhMJN,LohRJgQsoy & OukRfuZSGN,OHSQdBW & yQBPCtB|UffZfBXxG & L,VSgwkJ & fjeJkF,aCclqYD & pcJvOQyTBP|fALpC & trCdLsTN,iMhpuuu & PQthp,kYEEEty & eWxjTqLEWw,lCYKkH & v|rA & oJ,uv & HP,xQoynsmMZd & oqUEpEd#AHnqB & dR,AVsUkwPGA & SAsPwtqf,AYLODKrc & CZLvcxkJ,C & LawK|DH & aThJaGUb,DqRAQvyLl & BcWixMEeTg,EVXLiv & hxGp,H & LgIe|Hcv & afu,HrGpb & rKi,IAeLSrBeay & wOpjWxV,IS & iSuciS|JAYeu & edlGkU,JxrpwPAbVf & LBlf,KH & Ndl,KN & DSFLooc|MwT & ctVULePwmf,NTFyekDJ & xempXOuLe,NlpkXlMj & PeW,NotVEAMvl & OkXrvQ|OJyE & LQpGx,OW & fmiAoIw,PpjThNi & W,Q & BQRB,QGzaawNP & U^Qnrufd & b,RpbjUJ & mt,S & dtXU,UPVykA & iTr|UrGHUtaEdV & sEfd,VJlZy & XOe,VL & DYie|VfCkyNJbkw & hJQEAPcH,WBj & xXCLvBG,XOysZOe & qKe,ZbXgz & YPO|amvEnbfj & IkUpifmHYM,bNO & BTug,bPopa & tlmNyzPVMz^cQ & rJ,chCcc & rpQuAfUB,d & WtFyAonu,f & EfOF,f & NwZ|fzcHZCE & kC,gG & NSZI,hjjZz & jYTnYltRa|imYF & xnnLAIQAU,jOtEFdkU & vEnWrcHHWi,jvYlsfVx & SnrmTDSVO|kjvuJ & VvCkmmOXd,kliMIX & mltmXzLKM,kzCXo & gyNHh,l & oQJ|lIsdGo & caawh,lhNTrQI & Kuit,mIqqM & LpfeCcYH,mNBhZoxj & jCAhgxeHa,mTu & A,nBQFFEICl & AnFeXW^nTTxpxh & q,nm & IxoVPwOSnn,p & AZFtA,p & zoq,pWue & llmqmykhNZ,q & RPDm|rfDRuWTr & fm,rfV & ETphXuc,rsOvZZshJj & FJrHzRbnvY,sp & Zfe,t & nudZnRkXr,uYX & rZace,uqVMFc & tHUSjcWz|v & RVHlaIF,w & B,wCHmAwaMS & dTvDC,wfLMXX & YGGmrRxhoU|xim & fLmaZgHQ,yg & PculBtlnB,ymzPmx & wMGdXTI,yqRdW & yEcY,yuU & Qy";
        results_test1[5]="gIjGLSaZso & EgNgw#DD & NKWCJ,GMPTucvQop & GFeVwdBAE,LWeANp & H,PHSWvPF & NuTeqBj,TrLi & CZwQoVWRrr,XKBpA & qny,cJ & xazrN|jukawmVTx & afgU,nV & YVRJqGUOj,rHOtT & YxhphqCL,vJZNueCgrB & lXBVHWTHeU#A & Ddx,AT & hJgQNYHqV,B & qKFV,BsVBRxRqF & eqGrQbWt,BvUMztYLpw & bNJmP|DHhUj & aYNrnGMxr,DmpeAPB & chw,EAujOskzRx & ksmbWw,FHalBsl & iUUk,FYHQbByZjx & cfl,FkuhTvwOGh & fvk,FlAhYpW & UpmSBzR,GB & PrxU,GHXvZnxFI & ZjbwYTj|GOQpfzjVb & dNBCGS,GsQpA & Dywands,JAFk & o,Ky & sjEvNMDBNY,LOu & cOY,LSLUV & gob|Luax & gtBsL,MAkrKjhdjf & b,MGVpOPIH & xFBhxM,NHuA & J,ONER & AomR|PgDlSrAvzd & cHKU,QBAmImSSZ & OanfAMmvm,QYyLrCCkz & OQr,QiZncGfc & hUGuvQMxw,RAOn & oNoLsIUq,RL & nqRs,Roag & ZGmSezQ,SslUHkPPqL & HY,Tf & jVv|TvXi & mQ,VNG & baFKVd,VObcSMxp & JlIlXg,WChJplBjjB & zqWKrc|XxXyWqTamD & SyCmTaaJy,ZWkeAd & MpIBuPtk,ZWxqMFGOex & lQBKpw,aLd & dHjxGTTwIN,aza & ApPYdniYFD,b & XpV,cCdTSrZcMY & xGNKN|cXeXsE & oFHnBYqv,dfrTl & kNbFxQCiDD,eyv & PqqW,fawOWm & ngR,fhQw & C,fzMXoSNg & fjqS^gaWkEB & SfIwHujjYu,gjzKB & DcEFprIRf,i & EICZGIHLB,iwqCrBiPs & jyD,jIykPE & ZmIHRdNpYQ,jS & se,jivcPk & ufU|kxzqwyyS & Uf,kypVV & uT,lBkiaswv & QtbuC,mkSh & kbPsPpROY,mqE & LXAGdLMdb|o & BAMZwrm,oTJ & Pjz,oxpBiCT & TahLY,pQQlkHSYq & fVtgZNxcEq,qBgA & WAdESRN,qI & DPwDfjvh,qgxSWUmoE & FBzK,rCeYcYR & EYKtXXLKL,rFGpuWXYdL & eLtYZhw|rkgRqCckKz & hlhX,rspwRTxYx & o,sMl & z,sfXMqd & C,ssATbsJ & zPtTKSeWu,tFgRS & tzxeCRR,uoyWgdk & U|wN & D,wOHRGt & Hmdr,xCn & nzTt,xVWNgyV & ZMA,yDpsQc & eCZwgj,yjvUkRJHGn & ZfxzSSgCfy,z & AgFdQcit,zDkM & eOYjeMFdMQ,zt & xGfRYGVXh";
        results_test1[6]="YLrhxHDO & QZISx#FK & wlLm,JHIkKl & izmFVJ,KVM & dGbHuA,NkhMLAIJZF & VWSaFC,SpgVcBju & ZSJNhvcz|daPL & raiDFKPrVh,iEBHGcGodK & QyllGuOhCC,o & ppl,tIc & vJunBGaSn,tetN & aayGOrx,wScxipNg & YEQFe#A & BHcZksU,ADD & IKxczZaM,AEtvhAu & YfCys,AVFAMxPi & RTUFqxDLe,AqYgPR & cFbmVXHTS,DcP & d,DvmY & io,Eg & gmBQNXLIoL,ExFZogfQBk & Gu|FYCAi & MzDvFO,FiqsTAuisE & EvUIcXbl,H & wk,HqGTlGet & NG,HzqVugpKQ & DCBtJMybZ,IA & yiJXNz,J & ISt,J & aXaHsaMQmR|JVK & Jn,Jaj & qrfTxVO,JfTvwOmr & K,JhDj & eujy,K & T,KQbSBxVR & Q|LIutz & NJl,LOOJTU & w,Lrf & kKselP,MIUNMtnEvG & Ccv,MYZRog & aYnKCyAA|Q & XErly,Q & u,QWY & T,QsyUy & g,QuQHOqB & kDwAXWLTeq,R & vJENiZ,RUjAqcvmm & QQDdcMV,RYwKzC & ySlCf,RcteEHiDa & RuuUqlJk,SJ & IG|Tbobp & OkwCNkRB,VZCtqbVp & EBJxMSOip,XXNlDkAaOl & bZxhNMIO,XuyjmWP & heheCzl,Xym & WfpcgjagZD,YIBp & TELfKO^ZADyZuUbe & vpJT,aBmiR & hLGPq,al & WbASfN,bjMWy & VDhaqluER,cfn & ucrrbQYr|ebwiIcfJzM & fCvBrLEDme,gObtFXYqg & SqQrqMVV,ggOiPxI & rcaHXRIwQ,guRHMq & LcJseZys,hpwNXQqzJk & NVpm,htHdYHtseZ & Yy|jy & fGOeOVoXj,kMCUMR & AGzO,l & xhNgaRwMh,mreYS & eACzj,mwCVfi & jXhmj,nOkVy & EHKkdeRC|p & jmeKQSQlEb,pD & Ur,pWaMIbPXmt & EgkMbcDLg,qrwzD & WGNiSaHq,s & CGx,sjPVJx & OlYgaDd,t & cvOreuti,tGlWmAdSN & arNvAmF,tHRAlIpiZ & ArJCQL|tNxMsn & Mq,tOn & OcKSPQwlqx,tTRFANmAdu & HHiGidmvC,tWjETzBT & Z,tb & pel|tre & mpk,uQKDGCcu & srPme,uiHtRpFUj & fFx,vCRchqFh & vvJsbb,vvlAP & DungbXhQQi,vzVe & uJfAnyET|wkJtapEdRV & iENnUgGk,xQQtwycV & mqoDnrY,xcTdKV & ih,xhJ & s,xsClfIAt & peBblxWc,ym & pWDAJNYu,zPc & Ch";
        results_test1[7]="E & Gy,Ix & sWmyCMg,Nie & rgbxNTrPHz,PKbZtsdPIa & oWyIuq,VOMDlbv & uZInStEQFP,cNCKblU & mOu,fIaBSQVsB & HzNGjnyl,k & Mo,oMNNG & P,wQvZaNH & nDjEIZFr#AH & mWIfY,AILJMxwnfC & wSVZBoUFY,Aexvjcq & a,AveJPZK & YcPecG,CVUEZP & oJFQeGvk,CeHCElvOFB & Wlhfc,DCwWKDG & BAybHJ|EC & QNLlrL,EWY & D,EdnlcCU & Q,FQqkmKVTc & tSBhbSpx,FSn & xjyRtVJcvz,FavhkBTi & FtwadF,GOT & exGCbJ,HhTjYU & uo,IqJACkmC & FsEJRuRX|J & JuhgffhgkE,Jv & KbDrfNZEQ,KV & ej,Kdt & wnPmqnxaWf,LKT & KilYmFukZx,LVPPkmmNZc & mLdh,MecmDz & o|Njv & pDbDgdk,NyhGTVtulQ & KEz,OCkDhypY & uJD,OThTL & UXlfOBBF,Oa & i,P & U|QgVH & NCGVeWe,QuYeGKIB & CKknHBxliT,RDe & pcpkupGo,RK & umlEbsPhh,RVT & YvNQwIf,Rj & zUXber,T & gFQScycH,TZ & kZeEvLOSno,Tjm & dQXfhdxeIG|VuVFdoUNl & YTSQOMn,YSps & yJzWItP,ZNmdbpZN & nUrL,ZRzkV & WVC,bezxLrvagU & yTuC,c & G|cQhnX & wrZuXpClDm,cRShnq & dotfZTap,cpKpv & wpC,csOIm & bMQdZbYIW,dDwDTALHTR & GP,dPxWH & bbuYrwd,dfBObBXI & e|gEdZdioBKO & jMMxMPH,gccNDPfD & ZG,h & MEQuzYbtdT,iOasc & zC,jDcgkGP & SiC,jDxOWwJw & N,jpewFy & hBd|knrS & zoyJbHKe,lXmS & B,lxz & jO,mW & EvU,mYAnHMZoDV & MvINA,n & u,nGjqgJZ & EjXKAr,nZnEZWnG & TuvTndOiZy,nb & VOHD,niGsbSn & MBuA,noET & HaiU,o & URWhYK|oyKyFivvXa & VoLjYDVHk,p & GcuY,pthAT & ekd,pzfsZhiJE & kNaJK,rAICqhRVVQ & MKZuT,rmpMbo & GW,sktW & dLbzoZylzO,tl & KTrG,uJZOdtRgOH & OPqYOsbn,upSL & sp,vxfu & ncKJjhD|wRMXD & CoEw,xEOO & HHXwWCNA,xFmi & f,xMoxuXPF & bcHJlJI,xUwoDBb & zfVCySoyxN,xZCitW & SnkOXNJfYa,xvA & JzaLYQBNNH,y & MSeB,zvEWGC & SMUuJQBz";
        results_test1[8]="GSSL & ZdHBgzwnah,OgpnSDX & qqWCMRV,VhcZ & vrniNVOO,ZZBHny & JtXMY,dUHiLMbR & ydJbpYL,frwvuflyn & NZZnsUUQF,oYXfEj & i,vZNJ & fqf#A & mEKGguJyc,Ab & EP,BrDxh & LglSE,CPeAhcmEpS & A,ChLvj & vClWWm,CmpIHYf & VQCxlj,DKnB & KOzM,DVNTBmRFHM & Xu,EuNG & Trrx,FuKPcWTfGZ & cDeBWUo|GflQL & yJFSXfE,HA & S,HIkvmqEkg & jVZgUrPm,HTyatvcBq & SZciyUj,HrflFuEgOs & HGTHMwQWq,JXJdJ & jMT,JnXPLkIf & qe,LnkI & TPWEL,NpzJX & yGA,NtYDz & AUCaJgXfw|OtvAPHkobF & qBFG,PNhLKVML & pvY,PWADMKkNV & SADo,QVhcxhi & mLcvLVixwd,R & tczkx,Rt & mzhfDKDh,StNUXqxcr & T,TFrcNuSsp & eohnUIX,TkOh & wnN,TuuVBGn & ag,Tve & lzhqVAIx,ULvHL & HzV,VB & ixUQi,Vdcbb & piJkwSFuf|VlvSFvSme & tuztJXbww,WtieNqlH & uvAjHUOjRZ,XpbiC & EvWUPqWQ,YEWYiEDRG & wkyx,YFtTJ & VZhtF,YUMOM & pqBDLK,YYC & MLMQRYDYT,Yfz & GPplRMVvo|Zzkl & j,aA & VeezICYCGg,aKvtXdt & lR,aNDFZw & tpurcHLK,bYQo & YxMPhWPK,bmiHZthc & Q,cMJe & qMltXXd|dl & xwM,dmfLExOHm & RbolsfPE,e & Jevlmf,eILPIWYWCY & SkoryNQX,eMKVPQdpj & UcWeHgz,ecaOd & RtEXTH,fbjucqwEx & RCHzAnyq|i & khgznGKYkR,j & OLrc,jeQLDFw & WD,jiuVdvmy & JPSrdYntT,jpfhBKG & ZpTmkeuqea,lOCQt & mPvPd,liDOtxceMg & fO,mbHgs & Kg,nSPCQVIf & GvjU,nZfXh & Jv,nlVpe & iLLhHZXdc,noMWA & JCWN,nxBqPGt & aRFbKubC|pDeM & EJkrwVVco,q & LlnzHlCWi,qqpnEMYEc & SCskRg,u & QvmjwF,uI & sjWYoeK,uIVZ & I,ubOoSlO & pY,v & ZXAbmREh|vePc & vGeFTrS,vjsh & jNmDe,w & ZJ,wNWDIZ & FuXfXu,wjgIJB & cdFuqX,xFoim & rJvt,xHxdKZ & XoU,xI & ib,xjJtwPG & d,xtgKG & g,y & ryUfTwXoX,yJNWyz & DMEg,yQf & wWVLrce,zB & A,zKs & zKmJxgKYXl";
        results_test1[9]="JcPrfqM & E,QgtUAQqq & cJPmSdjC,XHENcA & rAMUr,cpck & FRxPm,j & xwwAtBiyMK,rO & MxPMEhj#AS & cEObBL,AqPcFtTv & kTvX,BaD & nz,CdgKPxB & LSGyonuY,DCOo & Thc,EFsLP & Gft,EWggTLtNx & WKxphI,EWiS & MOok,FIVHQBa & wAzRg,G & ZVO,GHlZhSqN & lIXv,GHnI & XZptkO,Hfk & uVHIfPMq,Ipc & qAaCkxWP,JASWRe & nmtGbfyxM,JG & SxiWqCmtyT,JUCCLkB & QnLN|K & dflG,KO & Fzhx,Km & lAseuwGie,KnIuQcZZfM & b,KynV & B,L & Ay,LjoS & BBQzf,MVeyBhTsT & FpnbBrdm,Mq & ROXyq,NSwHTCpf & Mi,NVNXS & GZW,OcK & cbV,QA & SSxlerk,QGGNfFU & fKzTGtit|ROh & vVtm,RdO & EOWerk,SWzRp & jO,SqQaCRP & aRLAt,T & rOFsETIfm,THBXUt & t,TJn & MckptuSgP,TzLivCakLj & yzCxota,UJJm & AvvkGUYg,WWTyFdygnF & SNbD,XFzEbLAsi & rUICk|XUkUqsGTWc & k,XwBLUPro & C,YANIffqT & N,YzkKhZMnDZ & aW,Z & rtrk,aCrsLQh & tbVIFeLMvN,aNAoxiyGq & tzOH,ancwhvKJ & lwdZMRGNb,bHuEdCh & uPgTrW,bNxEz & TjVtiAXjSJ,bqYa & FZ,bqv & JRGfJ,cOb & Mjue,ccbORR & XK,cizToJ & KI|dxWlgEg & rFmOs,eGTSBq & BLXqgCMcH,eWKI & Q,emLIXF & xAENzeXBZ,enr & OQ,eoKoDXh & KO,fi & eHsLEc,foyKBRERoF & OxTcyFAFTS,gX & UulyjgZxY,iZsWwPq & VQVPUJ,iwedUEuS & UgxiCx|jXe & NBD,lzbfYfL & eissdTpg,nD & FqGr,nHyUJRrTT & vtesgRaokR,nu & hwE,oedYUkV & YjfSwOEITs,pe & ZpG,ppXxW & Ldp,pyYuwm & eJUFJTJ,qIayClGV & BDbhcxGi|rmfxrZhXa & vEIgrFWKw,rnhl & JTzYYaSh,s & VwPKIw,sIUTIr & DkpehZYCB,spHfbRnD & rzBvDI,t & kxe,tILuaQKNjM & CrdLJRe,urUtWhxS & BX,vTJuKEHCK & pH,vaTPAS & UNqoSQZX,vfHWWcYN & JbZqIK,vgcpw & KKkNe,vxk & AOyACzqlAR,wKVHoansN & p,xbNpywYvlM & sNzcwB,zyjLIz & afy";
        results_test1[10]="HuqxGB & IyqWxwGQ,PrGI & hRZFqHJhGN,XmlVqG & eB,bJgRmdm & PoyUX,gU & WnhOZQf,pAhmimd & QDyFFBgr#BYLwxMQkWx & Om,By & ryxIfsmzH,CBqVbAZTpd & zwcOTHZrva,D & jZi,DItriLjv & xXYNa,DUV & pP,EKaAafjog & EwTKV,ErtgLXOg & mNujWGQZeh,FJSEqeZ & lXEqq,FwZYCRMh & Yzlkqd,GceLk & fXgfBpsT,GzTdODJ & AmecrS,HuhC & fFDtRLPO|I & GPXTOj,IkZ & AvIoF,JLdbtAy & fHluiW,JiPrgIDQCi & ClyUcIl,KbSLt & qvmx,KmaZqTazrE & pfYqbhW,KvEWQP & ZmjXL,Kwto & YclLRWZA,LHPuVOUi & o,LMIXDiM & iSqrc,LcnJuffCmZ & whmjQx,MpXFKKzNRw & sNh,OCmy & kna|PrrSGeh & tacnX,QY & rlOWSPDpA,RzLr & XAzhXsVna,SmlfnM & iateQ,SvhMGMKn & sDlCdTwHz,TQujwBSVAA & rRCQrMgMXA,TTVWsX & XJIOHZmUU,TUxwZYMEoa & mDXoAlQsXV,TjPHsQ & hDViLNK,TnMvxWd & OjPGWxfKOL,U & IKIwze,UGPqKIAokl & O,UMIHzQtHS & LFDgAZ,Upu & oXmIKzSCGZ,WIAAf & OiScHtZU,WViyRDJjkR & soawSGJFO,XShyRS & NNcsVUqMGD|Xqr & Q,Yp & mcfJrsZ,ZAIJsL & bdxE,ZHxqiaeUcx & BvOjKE,ZQtSwQVjb & kRDcD,aPUVwA & TJNxsz,aSUcMtlA & rGnq,arkQZmUcpC & aGRqwA,bBWwSGDmk & Jrsj,bFeD & UG|cSlelL & lI,cW & UZ,dr & ywgcUqKAVz,eLsI & KqVHofRXxP,eVCLwbRBE & ZxEExCiME,eqnsj & WJhqYryU,fbzFRLVYh & kv,fp & Tljr,g & lUYRsQ,gE & VUHApCTpW|h & ckxFIAH,hfCYpetQs & bXdYTkIH,hy & FXmKB,hzgn & PnCQWlfz,iaJtYuQe & DtY,jaKziehqu & eTBSf,jadBxXdS & MYsrNW,jgQZMKohP & eMjW,lQ & Kob,lTvVbd & W,lhji & j,mTxnBiq & KLhFu,nCRrja & c,nyjzHLf & sCOafTfp,oBDtqzm & GRAr|pF & SmROSzeUP,pRM & BRiUxcX,q & p,qGxgoUNpK & S,qx & yFbbgqDYg,rNpinxJinj & BwaDgBypXJ,rpmhgsJR & sC,suZ & UGGl,tGMTNvtk & J,tbYpgcXQ & a,tezAwY & MGYW,ttjHcJku & JfLBCdHof,ui & LTvOIsZSaH,v & WVgRsutBZm,vn & INP,yV & CquCKJ";

        System.out.print("TEST 1: ");//toString of random friends trees with different t values
        boolean flag=true;
        for (int i = 1; i <=10 & flag ; i++){
            BTree tree=new BTree(Math.max(2,i)+"");
            tree.createFullTree("friends"+i+".txt");
            String yourAns=tree.toString();
            String myAns=results_test1[i];
            if(!myAns.equals(yourAns)){
                if(flag) {
                    System.out.println("FAILED");
                    printTree(yourAns);
                    printTree(myAns);
                }
                flag = false;
                System.out.println("bad! " + i);
                int badindex=firstDiff(yourAns,myAns);
                if(badindex==-1)
                    System.out.println("your answer is sub-string of the real one");
                if(badindex==-2)
                    System.out.println("the real answer is sub-string of yours");
                else
                    System.out.println("you wrote"+yourAns.charAt(badindex)+"i wrote "+myAns.charAt(badindex));
            }
        }
        if(flag)
            System.out.println("PASS");
        Class btreeClass=BTree.class;
        String methodName="";
        boolean isMethod_contains_exist=false;
        String methodNames="contains,search,Search,isExist,isContain,isContaining,find,BTree_Search,Tree_Search,BTreeSearch,TreeSearch,Btree_search,BtreeSearch,treeSearch";
        for (Method method : btreeClass.getDeclaredMethods()) {
            if (methodNames.contains(method.getName())||methodNames.toLowerCase().contains(method.getName())) {
                if(method.getReturnType().toString().equals(Boolean.TYPE.toString())){
                    Class[] pars = method.getParameterTypes();
                    if (pars.length == 1 && pars[0].toString().equals(String.class.toString())){
                        isMethod_contains_exist = true;
                        methodName=method.getName();
                    }
                }
            }
        }

        if(!isMethod_contains_exist){
            System.out.println("'TEST 2' cannot be applied."+
                    "\nplease, implement a method with signature 'boolean contains(String)'."+
                    "\nthe method receive key to search in the tree and return if the tree contains the key");
        }
        else{
            Method searchMethod;
            try{
                searchMethod = BTree.class.getDeclaredMethod(methodName,String.class);
            }
            catch (NoSuchMethodException e){
                throw new RuntimeException("Error in the tester! tell yuval zilber bout that");
            }
            System.out.print("TEST 2: ");
            flag=true;
            for (int t = 2; t <= 10 & flag; t++){

                BTree tree = new BTree(t + "");
                int[] arr = new int[1000];
                //fill array and tree with the same values
                SecureRandom rnd = new SecureRandom();
                arr[0] = rnd.nextInt(100000);
                tree.insert(arr[0] + "");
                do{
                    arr[1] = rnd.nextInt(100000);
                    tree.insert(arr[1] + "");
                } while (arr[1] == arr[0]);
                for (int i = 2; i < arr.length; i++){
                    int tmp = rnd.nextInt(100000);
                    if (!isArrContains(arr,tmp)){
                        arr[i] = tmp;
                        tree.insert(tmp + "");
                    } else{
                        i--;
                    }
                }
                //now, the array and the tree contains the same values.
                //the test
                Arrays.sort(arr, 0, arr.length );
                for (int i = 0; i < 100000 & flag; i++){
                    int pos = Arrays.binarySearch(arr, 0, arr.length, i);
                    //the value is inside the array, means i inserted it to the Btree.
                    boolean isInTree;
                    try{
                        isInTree = (Boolean)searchMethod.invoke(tree,i+"");
                    } catch (IllegalAccessException | InvocationTargetException e){
                        throw new RuntimeException("Error in the tester! tell yuval zilber bout that");
                    }
                    if (pos >= 0){
                        if(!isInTree){
                            System.out.println("FAILED.\nyou don't find an existing value");
                            flag=false;
                        }
                    }
                    else{
                        if(isInTree){
                            System.out.println("FAILED.\nyou find non-existing value");
                            flag=false;
                        }
                    }
                }
            }
            if(flag)
                System.out.println("PASS");
        }
        flag=false;
        System.out.print("TEST 3: ");//throwing exceptions of Btree
        try{
            new BTree("k");
        }
        catch (IllegalArgumentException iae){
            try{
                new BTree("1");
            }
            catch (IllegalArgumentException iae2){
                try{
                    new BTree("3.5");
                }
                catch (IllegalArgumentException iae3){
                    try{
                        new BTree("-4");
                    }
                    catch (IllegalArgumentException iae4){
                        flag=true;
                    }
                    catch (Exception e){
                        System.out.println("FAILED - you don't throw an exception for -4 as parameter t");
                    }
                }
                catch (Exception e){
                    System.out.println("FAILED - you don't throw an exception for 3.5 as parameter t");
                }
            }
            catch (Exception e){
                System.out.println("FAILED - you don't throw an exception for 1 as parameter t");
            }
        }
        catch (Exception e){
            System.out.println("FAILED.\nyou don't throw an exception for 'k' as parameter t");
        }
        if(flag)
            System.out.println("PASS");
        else
            System.out.println("FAILED.\nyou don't throw an exception yourself, check if t is a number before u convert it");

        System.out.print("TEST 4: ");
        Messages msgs=new Messages();
        msgs.generateMessages("messages0.txt");
        BTree tree=new BTree("2");
        tree.createFullTree("friends0.txt");
        msgs.createHashTables("10");
        String str=msgs.findSpams("spam_words0.txt",tree);
        System.out.println(str.equals("0,1,4,7,9")?"PASS":"FAILED");
        flag=true;
        System.out.print("TEST 5: ");
        try{
            msgs.createHashTables("10");
            str = msgs.findSpams("spam_words1.txt", tree);
        }
        catch (Exception e){
            flag=false;
            System.out.println("FAILED - you throw an exception on empty 'spam_words1.txt' file");
        }
        finally{
            if(flag)
                System.out.println(str.equals("")?"PASS":"FAILED - for empty 'spam_words1.txt' file return empty string");
        }
        flag=true;
        msgs=new Messages();
        System.out.print("TEST 6: ");
        try{
            msgs.generateMessages("messages1.txt");
            msgs.createHashTables("10");
            str=msgs.findSpams("spam_words0.txt",tree);
        }
        catch (Exception e){
            flag = false;
            System.out.println("FAILED - you throw an exception on empty 'messages1.txt' file, don't");
        }
        finally{
            if(flag)
                System.out.println(str.equals("") ? "PASS" : "FAILED - for empty 'spam_words1.txt' file return empty string");
        }
        flag=true;
        System.out.print("TEST 7: ");
        try{
            msgs.generateMessages("messages2.txt");
            msgs.createHashTables("10");
            str = msgs.findSpams("spam_words0.txt", tree);
        }
        catch (Exception e){
            flag=false;
            System.out.println("FAILED - throw exception on single message in 'messages2.txt' file");
        }
        if(flag)
            System.out.println(str.equals("0")?"PASS":"FAILED - supposed to fine the 1 message as spam");
        flag=false;
        System.out.print("TEST 8: ");
        try{
            msgs.createHashTables("k");
        }
        catch (IllegalArgumentException iae){
            try{
                msgs.createHashTables("0");
            }
            catch (IllegalArgumentException iae1){
                try{
                    msgs.createHashTables("1.5");
                }
                catch (IllegalArgumentException iae2){
                    try{
                        msgs.createHashTables("-2");
                    }
                    catch (IllegalArgumentException iae3){
                        flag=true;
                    }
                    catch (Exception e){
                        System.out.println("FAILED - you don't throw an exception for -2 as parameter m");
                    }
                }
                catch (Exception e){
                    System.out.println("FAILED - you don't throw an exception for 1.5 as parameter m");
                }
            }
            catch (Exception e){
                System.out.println("FAILED - you don't throw an exception for 0 as parameter m");
            }
        }
        catch (Exception e){
            System.out.println("FAILED - you don't throw an exception for 'k' parameter m");
        }
        if(flag)
            System.out.println("PASS");
        else
            System.out.println("FAILED - you don't throw an exception for illegal parameter m");
    }
    private static boolean isArrContains(int[] arr,int key){
        for (int anArr : arr){
            if (anArr == key)
                return true;
        }
        return false;
    }

    private static int firstDiff(String str1,String str2){
        String shorter=str1;
        String longer=str2;
        if(str2.length()<str1.length()){
            shorter=str2;
            longer=str1;
        }
        for (int i = 0; i < shorter.length(); i++){
            if(shorter.charAt(i)!=longer.charAt(i))
                return i;
        }
        if(shorter.equals(str1))
            return -1;
        return -2;
    }
}
