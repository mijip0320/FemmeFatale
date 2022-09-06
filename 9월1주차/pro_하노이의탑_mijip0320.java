{\rtf1\ansi\ansicpg949\cocoartf2639
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset129 AppleSDGothicNeo-Regular;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 import java.util.*;\
\
class Solution \{\
    \
    public static ArrayList<int[]> list;\
\
    public int[][] solution(int n) \{\
        \
      list = new ArrayList<>();\
        \
        hanoi(n, 1, 3, 2);\
        \
        int[][] answer = new int[list.size()][2];\
        for(int i = 0 ; i < list.size() ; ++i)\{\
            int[] ans = list.get(i);\
            answer[i][0] = ans[0];\
            answer[i][1] = ans[1];  \
        \}\
        \
        return answer;\
    \}\
    \
    public static void hanoi(int n, int from, int to, int via)\{\
        int[] move = \{from, to\};\
       if(n == 1)\{//n
\f1 \'c0\'cc
\f0  1
\f1 \'c0\'cf
\f0  
\f1 \'b6\'a7
\f0 \
           list.add(move);//
\f1 \'c3\'e2\'b9\'df\'c1\'f6\'c0\'c7
\f0  
\f1 \'bf\'f8\'c6\'c7\'c0\'bb
\f0  
\f1 \'b5\'b5\'c2\'f8\'c1\'f6\'b7\'ce
\f0  
\f1 \'bf\'c5\'b1\'e4\'b4\'d9
\f0 .\
       \} \
            \
        else\{//
\f1 \'b3\'aa\'b8\'d3\'c1\'f6\'c0\'c7
\f0  
\f1 \'b0\'e6\'bf\'ec
\f0 \
            hanoi(n - 1, from, via, to);//
\f1 \'c3\'e2\'b9\'df\'c1\'f6\'bf\'a1
\f0  
\f1 \'c0\'d6\'b4\'c2
\f0  n - 1
\f1 \'b0\'b3\'c0\'c7
\f0  
\f1 \'bf\'f8\'c6\'c7\'c0\'bb
\f0  
\f1 \'b0\'e6\'c0\'af\'c1\'f6\'b7\'ce
\f0  
\f1 \'bf\'c5\'b1\'e4\'b4\'d9
\f0 .\
            list.add(move);//
\f1 \'c3\'e2\'b9\'df\'c1\'f6\'bf\'a1
\f0  
\f1 \'c0\'d6\'b4\'c2
\f0  
\f1 \'c7\'d1
\f0  
\f1 \'b0\'b3\'c0\'c7
\f0  
\f1 \'bf\'f8\'c6\'c7\'c0\'bb
\f0  
\f1 \'b5\'b5\'c2\'f8\'c1\'f6\'b7\'ce
\f0  
\f1 \'bf\'c5\'b1\'e4\'b4\'d9
\f0 .\
            hanoi(n - 1, via, to, from);//
\f1 \'b0\'e6\'c0\'af\'c1\'f6\'bf\'a1
\f0  
\f1 \'c0\'d6\'b4\'c2
\f0  n - 1
\f1 \'b0\'b3\'c0\'c7
\f0  
\f1 \'bf\'f8\'c6\'c7\'c0\'bb
\f0  
\f1 \'b5\'b5\'c2\'f8\'c1\'f6\'b7\'ce
\f0  
\f1 \'bf\'c5\'b1\'e4\'b4\'d9
\f0 .\
        \}\
            \
    \}\
\}}