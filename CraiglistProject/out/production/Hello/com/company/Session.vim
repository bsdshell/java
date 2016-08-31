let SessionLoad = 1
if &cp | set nocp | endif
let s:cpo_save=&cpo
set cpo&vim
inoremap <F7> =LineCompleteFromFile()
inoremap <F1> =CompleteJava()
map! <D-v> *
nnoremap <silent>  :nohlsearch
map ,w :w! 
map ,c :.,$s/\S.*\S/\\\0/gc | :nohlsearch 
map ,n :nohlsearch 
map ,nl :.,$s/\S.*\S/\0<br>/gc | :nohlsearch 
map \rwp <Plug>RestoreWinPosn
map \swp <Plug>SaveWinPosn
vmap <silent> \tt :call AlignMaps#Vis("tt")
nmap \tt <Plug>AM_tt
vmap <silent> \tsq :call AlignMaps#Vis("tsq")
nmap \tsq <Plug>AM_tsq
vmap <silent> \tsp :call AlignMaps#Vis("tsp")
nmap \tsp <Plug>AM_tsp
vmap <silent> \tml :call AlignMaps#Vis("tml")
nmap \tml <Plug>AM_tml
vmap <silent> \tab :call AlignMaps#Vis("tab")
nmap \tab <Plug>AM_tab
vmap <silent> \m= :call AlignMaps#Vis("m=")
nmap \m= <Plug>AM_m=
vmap <silent> \tW@ :call AlignMaps#Vis("tW@")
nmap \tW@ <Plug>AM_tW@
vmap <silent> \t@ :call AlignMaps#Vis("t@")
nmap \t@ <Plug>AM_t@
vmap <silent> \t~ :call AlignMaps#Vis("t~")
nmap \t~ <Plug>AM_t~
vmap <silent> \t? :call AlignMaps#Vis("t?")
nmap \t? <Plug>AM_t?
vmap <silent> \w= :call AlignMaps#Vis("w=")
nmap \w= <Plug>AM_w=
vmap <silent> \ts= :call AlignMaps#Vis("ts=")
nmap \ts= <Plug>AM_ts=
vmap <silent> \ts< :call AlignMaps#Vis("ts<")
nmap \ts< <Plug>AM_ts<
vmap <silent> \ts; :call AlignMaps#Vis("ts;")
nmap \ts; <Plug>AM_ts;
vmap <silent> \ts: :call AlignMaps#Vis("ts:")
nmap \ts: <Plug>AM_ts:
vmap <silent> \ts, :call AlignMaps#Vis("ts,")
nmap \ts, <Plug>AM_ts,
vmap <silent> \t= :call AlignMaps#Vis("t=")
nmap \t= <Plug>AM_t=
vmap <silent> \t< :call AlignMaps#Vis("t<")
nmap \t< <Plug>AM_t<
vmap <silent> \t; :call AlignMaps#Vis("t;")
nmap \t; <Plug>AM_t;
vmap <silent> \t: :call AlignMaps#Vis("t:")
nmap \t: <Plug>AM_t:
vmap <silent> \t, :call AlignMaps#Vis("t,")
nmap \t, <Plug>AM_t,
vmap <silent> \t# :call AlignMaps#Vis("t#")
nmap \t# <Plug>AM_t#
vmap <silent> \t| :call AlignMaps#Vis("t|")
nmap \t| <Plug>AM_t|
vmap <silent> \T~ :call AlignMaps#Vis("T~")
nmap \T~ <Plug>AM_T~
vmap <silent> \Tsp :call AlignMaps#Vis("Tsp")
nmap \Tsp <Plug>AM_Tsp
vmap <silent> \Tab :call AlignMaps#Vis("Tab")
nmap \Tab <Plug>AM_Tab
vmap <silent> \TW@ :call AlignMaps#Vis("TW@")
nmap \TW@ <Plug>AM_TW@
vmap <silent> \T@ :call AlignMaps#Vis("T@")
nmap \T@ <Plug>AM_T@
vmap <silent> \T? :call AlignMaps#Vis("T?")
nmap \T? <Plug>AM_T?
vmap <silent> \T= :call AlignMaps#Vis("T=")
nmap \T= <Plug>AM_T=
vmap <silent> \T< :call AlignMaps#Vis("T<")
nmap \T< <Plug>AM_T<
vmap <silent> \T; :call AlignMaps#Vis("T;")
nmap \T; <Plug>AM_T;
vmap <silent> \T: :call AlignMaps#Vis("T:")
nmap \T: <Plug>AM_T:
vmap <silent> \Ts, :call AlignMaps#Vis("Ts,")
nmap \Ts, <Plug>AM_Ts,
vmap <silent> \T, :call AlignMaps#Vis("T,")
nmap \T, <Plug>AM_T,
vmap <silent> \T# :call AlignMaps#Vis("T#")
nmap \T# <Plug>AM_T#
vmap <silent> \T| :call AlignMaps#Vis("T|")
nmap \T| <Plug>AM_T|
map \Htd <Plug>AM_Htd
vmap <silent> \anum :call AlignMaps#Vis("anum")
nmap \anum <Plug>AM_anum
vmap <silent> \aenum :call AlignMaps#Vis("aenum")
nmap \aenum <Plug>AM_aenum
vmap <silent> \aunum :call AlignMaps#Vis("aunum")
nmap \aunum <Plug>AM_aunum
vmap <silent> \afnc :call AlignMaps#Vis("afnc")
nmap \afnc <Plug>AM_afnc
vmap <silent> \adef :call AlignMaps#Vis("adef")
nmap \adef <Plug>AM_adef
vmap <silent> \adec :call AlignMaps#Vis("adec")
nmap \adec <Plug>AM_adec
vmap <silent> \ascom :call AlignMaps#Vis("ascom")
nmap \ascom <Plug>AM_ascom
vmap <silent> \aocom :call AlignMaps#Vis("aocom")
nmap \aocom <Plug>AM_aocom
vmap <silent> \adcom :call AlignMaps#Vis("adcom")
nmap \adcom <Plug>AM_adcom
vmap <silent> \acom :call AlignMaps#Vis("acom")
nmap \acom <Plug>AM_acom
vmap <silent> \abox :call AlignMaps#Vis("abox")
nmap \abox <Plug>AM_abox
vmap <silent> \a( :call AlignMaps#Vis("a(")
nmap \a( <Plug>AM_a(
vmap <silent> \a= :call AlignMaps#Vis("a=")
nmap \a= <Plug>AM_a=
vmap <silent> \a< :call AlignMaps#Vis("a<")
nmap \a< <Plug>AM_a<
vmap <silent> \a, :call AlignMaps#Vis("a,")
nmap \a, <Plug>AM_a,
vmap <silent> \a? :call AlignMaps#Vis("a?")
nmap \a? <Plug>AM_a?
nmap <silent> \c :call CopyJavaMethod()
nmap <silent> \d :!open dict://<cword>
map _in :call IncreaseColor() 
nmap gx <Plug>NetrwBrowseX
nnoremap gO :!open <cfile>
vmap mbf$ :s/\%V.*\%V/$\\mathbf{\0}$/ 
vmap mbf :s/\%V.*\%V/\\mathbf{\0}/ 
vmap tbf$ :s/\%V.*\%V/$\\textbf{\0}$/ 
vmap tbf :s/\%V.*\%V/\\textbf{\0}/ 
vmap xu :s/\%V\_^\s*\zs\/\/\%V//g 
vmap xx :s/\%V\_^\%V/\/\//g 
map <F9> :w! | :!/Users/cat/myfile/script/jav.sh % 
nnoremap <silent> <Plug>NetrwBrowseX :call netrw#NetrwBrowseX(expand("<cWORD>"),0)
nmap <silent> <Plug>RestoreWinPosn :call RestoreWinPosn()
nmap <silent> <Plug>SaveWinPosn :call SaveWinPosn()
nmap <SNR>14_WE <Plug>AlignMapsWrapperEnd
map <SNR>14_WS <Plug>AlignMapsWrapperStart
map <S-F10> :call       ToggleColorScheme() 
map <F5> :tabnew /Users/cat/myfile/github/snippets/snippet.m | :tabnew /Users/cat/myfile/github/snippets/snippet.vimrc 
map <F10> :tabc        
map <F4> :tabnew     
map <F3> :tabn       
map <F2> :tabp       
vmap <BS> "-d
vmap <D-x> "*d
vmap <D-c> "*y
vmap <D-v> "-d"*P
nmap <D-v> "*P
imap ,w  :w! 
imap ,nl :.,.s/^\S.*$/\0<br>/gc | :nohlsearch 
cmap BB s//\[\0\]/  
cmap SV vim // **/*.m
cmap SS .,$s///gc
cmap White /\S\zs\s\+$
iabbr xpp [path moveToPoint:CGPointMake(location.x, location.y)];[path addLineToPoint:CGPointMake(location.x + width, location.y)];[path addLineToPoint:CGPointMake(location.x + width, location.y + height)];[path addLineToPoint:CGPointMake(location.x, location.y + height)];[path addLineToPoint:CGPointMake(location.x, location.y)];
cabbr ;; :.,.s/$/;/ | :nohlsearch
cabbr ww :call HeaderSource()
cabbr ffr :call RemoveDuplicatedTabs()
cabbr ffu :call FindFun()
cabbr dv :call DeVariable()
cabbr df :call Defun()
cabbr ttd :call Test(@")
cabbr cd /Users/cat/myfile/github/java/CraiglistProject/src/
cabbr kk cd /Users/cat/myfile/github/java/CraiglistProject/src/
cabbr Mat :!/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome  http://localhost/zsurface/html/indexLatexMatrix.html
cabbr Color :!/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome https://upload.wikimedia.org/wikipedia/en/1/15/Xterm_256color_chart.svg
cabbr Font :!/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome http://zsurface.com/image/latexfont.png -incongnito 
cabbr Greek :!/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome http://zsurface.com/image/greek1.png -incongnito 
cabbr example :!/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome http://zsurface.com/html/indexLatexExample.html -incongnito 
iabbr <expr> jll_ListOfList 'ArrayList<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();' . "\" . "^"
iabbr <expr> jm_HashMap 'Map<String, Integer> map = new HashMap<String, Integer>();' . "\" . "^"
iabbr <expr> jl 'List<String> list = new ArrayList<String>();' . "\" . "^" . ":.,.s/String/Integer/gc" . ""
iabbr <expr> jim 'import java.io.*;import java.lang.String;import java.util.*;' . "\" . "^"
iabbr <expr> for2_two_for_loop 'for(int xxx=0; xxx < 9; xxx++){for(int xxx=0; xxx < 9; xxx++){}}' . "\" . "3k" . "^" . ":.,.s/xxx/i/gc" . ""
iabbr <expr> forr_one_for_loop 'for(int xxx=0; xxx<10; xxx++){}' . "\" . "1k" . "^". ":.,.s/xxx/i/gc" . ""
iabbr <expr> jsys_system_out 'System.out.println(xxx)' . "\" . "^" . ":.,.s/xxx/i/gc" . ""
iabbr <expr> r- "// ".'80i-' . ""
iabbr <expr> r= "// ".'80i=' . ""  
iabbr skk // searchkey:
cabbr pl :call ListTabPage() 
cabbr bufm :call ToggleBufferManager() 
cabbr No :tabnew /Library/WebServer/Documents/tiny3/noteindex.txt 
cabbr Cl :tabe /Library/WebServer/Documents/zsurface/html/indexCommandLineTricks.html  
cabbr Eng :tabe /Library/WebServer/Documents/zsurface/html/indexEnglishNote.html  
cabbr Evimt :tabe /Library/WebServer/Documents/zsurface/html/indexVimTricks.html
cabbr Enote :tabe /Library/WebServer/Documents/zsurface/html/indexDailyNote.html
cabbr Esty :tabe /Library/WebServer/Documents/zsurface/style.css
cabbr Sty :%!astyle --style=java 
cabbr Sni :tabnew $g/snippets/objectivec.m 
cabbr Tiny :!/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome  tiny3.com  -incongnito 
cabbr mm :marks
cabbr wo :tabe /Users/cat/myfile/github/vim/myword.utf-8.add    " My words file
cabbr qn :tabe /Users/cat/myfile/github/quicknote/quicknote.txt " quick node
cabbr mk :mksession! $sess                                  " save vim session
cabbr ep :tabnew /etc/profile 
cabbr eb :tabe ~/.bashrc
cabbr ev :tabe /Users/cat/myfile/github/vim/vim.vimrc
cabbr sv :source /Users/cat/myfile/github/vim/vim.vimrc | :tabdo e! 
inoreabbr \date\ =strftime("%d-%d-%Y @ %H:%M")
let &cpo=s:cpo_save
unlet s:cpo_save
set autochdir
set autoindent
set autoread
set backspace=2
set complete=.,w,b,u,t,i,k/Users/cat/myfile/github/java/*,k/Users/cat/myfile/github/JavaLib/*,k/Users/cat/myfile/github/Jsource/*
set dictionary=~/myfile/github/vim/words.txt,~/myfile/github/vim/myword.utf-8.add
set expandtab
set fileencodings=ucs-bom,utf-8,default,latin1
set helplang=en
set hlsearch
set laststatus=2
set omnifunc=csscomplete#CompleteCSS
set ruler
set shell=/Applications/fish.app/Contents/Resources/base/bin/fish
set shiftwidth=4
set showcmd
set smartindent
set spellfile=~/myfile/github/vim/myword.utf-8.add
set statusline=%F[%-2.5n]\ %l:%c\ %r\ %m\ %{CheckToggleBracketGroup()}
set noswapfile
set tabstop=4
set notimeout
set timeoutlen=100
set ttimeout
set undodir=~/.vim/undo
set undofile
set nowritebackup
let s:so_save = &so | let s:siso_save = &siso | set so=0 siso=0
let v:this_session=expand("<sfile>:p")
silent only
cd ~/myfile/github/java/CraiglistProject/src/com/company
if expand('%') == '' && !&modified && line('$') <= 1 && getline(1) == ''
  let s:wipebuf = bufnr('%')
endif
set shortmess=aoO
badd +199 ~/myfile/github/java/CraiglistProject/src/com/company/Main.java
badd +0 com/company/Main.java
badd +27 ~/myfile/github/JavaLib/Aron.java
badd +1436 /Library/WebServer/Documents/tiny3/noteindex.txt
badd +1 /Users/cat/myfile/github/java/CraiglistProject/src/com/company
badd +0 /Library/WebServer/Documents/tiny3/file.html
badd +476 ~/myfile/github/java/CraiglistProject/src/com/company/resource/html/2.html
badd +806 ~/myfile/github/java/CraiglistProject/src/com/company/resource/p1.html
badd +5 /private/tmp/x.x
badd +94 ~/myfile/github/java/CraiglistProject/src/com/company/resource/page1.html
badd +23 ~/myfile/github/java/CraiglistProject/src/com/company/resource/free.html
badd +1 ~/myfile/github/java/CraiglistProject/src/com/company/resource/free1.html
badd +34 /Library/WebServer/Documents/tiny3/test/2.html
badd +131 ~/.viminfo
badd +91 /Library/WebServer/Documents/zsurface/html/indexVimTricks.html
badd +0 /opt/local/share/vim/vim74/doc/@a
badd +0 ~/myfile/github/JavaLib/@a
badd +0 ~/myfile/github/snippets/snippet.m
badd +0 ~/myfile/github/snippets/snippet.vimrc
badd +864 ~/myfile/github/vim/vim.vimrc
badd +0 /Library/WebServer/Documents/zsurface/html/indextesttry.html
argglobal
silent! argdel *
argadd com/company/Main.java
edit ~/myfile/github/java/CraiglistProject/src/com/company/Main.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
nmap <buffer> ;; /%%%c3l
vmap <buffer> str :s/\%V.*\%V/"\0"/ 
imap <buffer> ;; /%%%c3l
imap <buffer> ;fo mzfor( %%%; %%%; %%%){ // %%%%%%}'z;;
iabbr <buffer> jlist2d_String List<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();
iabbr <buffer> jlist2d_Integer List<ArrayList<Integer>> list2d = new ArrayList<ArrayList<Integer>>();
iabbr <buffer> jset_String Set<Integer> set = new HashSet<Integer>(Arrays.asList("cat", "dog"));
iabbr <buffer> jset_Integer Set<String> set = new HashSet<String>(Arrays.asList(1, 2));
iabbr <buffer> filee //[ file=kk.html title=""
iabbr <buffer> jme public static List<String> get(){}
iabbr <buffer> jmap_String_String Map<String, String> map = new HashMap<String, String>();
iabbr <buffer> jmap_Integer_Integer Map<Integer, Integer> map = new HashMap<Integer, Integer>();
iabbr <buffer> jmap_iterator_String Map<String, String> map = new HashMap<String, String>();for(Map.Entry<String, String> entry : map.entrySet()){System.out.println("[" + entry.getKey() + " , " + entry.getValue() + "]");}
iabbr <buffer> jmap_iterator_Integer Map<Integer, Integer> map = new HashMap<Integer, Integer>();for(Map.Entry<Integer, Integer> entry : map.entrySet()){System.out.println("[" + entry.getKey() + " , " + entry.getValue() + "]");}
iabbr <buffer> jtoken StringTokenizer stoken = new StringTokenizer(exp, "+-/*", true);List<String> list = new ArrayList<String>();while(stoken.hasMoreTokens()){String token = stoken.nextToken();list.add(token);System.out.println(token);}
iabbr <buffer> jstack_String Stack<String> stack = new Stack<String>();
iabbr <buffer> jstack_Integer Stack<Integer> stack = new Stack<Integer>();
iabbr <buffer> jqueue_Integer Queue<Integer> queue = new ArrayList<Integer>();
iabbr <buffer> jqueue_String Queue<String> queue = new ArrayList<String>();
iabbr <buffer> jvector_Integer List<Integer> list = new Vector<Integer>();
iabbr <buffer> jvector_String List<String> list = new Vector<String>();
iabbr <buffer> jclass_dummy_class class MyClass{public MyClass(){}public print(){}}
iabbr <buffer> jgen_generic_type public static <T> void printList(List<T> list) {}
iabbr <buffer> jran_random Random ran = new Random();// 0 - 9int num = ran.nextInt(10);Print.p(num);
iabbr <buffer> jlist_Iterator List<String> list = new String<String>();for(String s : list){Print.pl(s);}
iabbr <buffer> jlist_Integer List<Integer> list = new ArrayList<Integer>();
iabbr <buffer> jlist_String List<String> list = new ArrayList<String>();
iabbr <buffer> jlist_Node List<Node> list = new ArrayList<Node>();
iabbr <buffer> jpriority_PriorityQueue Queue<String> queue = new PriorityQueue<String>();
iabbr <buffer> jite_Iterator List<String> list = ArrayList<String>();Iterator<String> ite = list.iterator();
iabbr <buffer> jpriority_queue_full_example Queue<Interval> queue = new PriorityQueue<Interval>();Interval ter1 = new Interval(1, 4, 10);Interval ter2 = new Interval(4, 4, 2);Interval ter3 = new Interval(2, 8, 10);queue.add(ter1);queue.add(ter2);queue.add(ter3);while(!queue.isEmpty()) {Print.p(queue.poll());}
iabbr <buffer> jpriorityqueue_Interval_Example class Interval implements Comparable<Interval>{int start;int end;int data;public Interval(int start, int end, int data){this.start = start;this.end = end;this.data = data;}public int compareTo(Interval e){if(e != null){return start - e.start;}throw new IllegalArgumentException("e must not be null");}public String toString(){return "[" + start + "][" + end + "][" + data + "]";}}//public class Try102{//    public static void main(String[] args) {//        test0();//    }//    static void test0(){//        Aron.beg();//        Queue<Interval> queue = new PriorityQueue<Interval>();//        Interval ter1 = new Interval(1, 4, 10);//        Interval ter2 = new Interval(4, 4, 2);//        Interval ter3 = new Interval(2, 8, 10);//        Interval ter4 = new Interval(3, 4, 5);//        queue.add(ter1);//        queue.add(ter2);//        queue.add(ter3);//        queue.add(ter4);////        while(!queue.isEmpty()){//            Print.p(queue.poll());//        }//        Aron.end();//    }//}
iabbr <buffer> jda_java_data_structure List<String> list = new ArrayList<String>();List<String> list = new LinkedList<String>();List<String> list = new Stack<String>();List<String> list = new Vector<String>();Queue<String> queue = new ArrayList<String>();Queue<String> queue = new PriorityQueue<String>();
iabbr <buffer> jqueue_copy Queue<Node> q = new LinkedList(oldQueue);
iabbr <buffer> jclassfile_import_classfile import classfile.*;
iabbr <buffer> jbst_Binary_Tree BST b1 = new BST();b1.insert(10);b1.insert(5);b1.insert(15);b1.insert(1);b1.insert(7);
iabbr <buffer> tess static void test0(){Aron.beg();Aron.end();}static void test1(){Aron.beg();Aron.end();}static void test2(){Aron.beg();Aron.end();}
iabbr <buffer> jheadd import java.util.ArrayList;import java.util.List;import java.util.StringTokenizer;import java.util.Vector;
iabbr <buffer> forr2 for(int i=0; i<len; i++){for(int j=0; j<len; j++){}}
iabbr <buffer> forr for(int i=0; i<len; i++){}
iabbr <buffer> prr System.out.println("[" + xxx + "]");
iabbr <buffer> prr_ System.out.println("[" + xxx + "]");System.out.println("\n---------------------------------");
iabbr <buffer> jarr_array2d_one_8x8 int[][] arr2d = {{1, 1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1, 1},};int height = arr2d.length;int width = arr2d[0].length;
iabbr <buffer> jarr_array2d_zero_8x8 int[][] arr2d = {{0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0},};int height = arr2d.length;int width = arr2d[0].length;
iabbr <buffer> jarr_array2d_one_4x4 int[][] arr2d = {{1, 1, 1, 1},{1, 1, 1, 1},{1, 1, 1, 1},{1, 1, 1, 1},{1, 1, 1, 1},};int height = arr2d.length;int width = arr2d[0].length;
iabbr <buffer> jarr_array2d_zero_4x4 int[][] arr2d = {{0, 0, 0, 0},{0, 0, 0, 0},{0, 0, 0, 0},{0, 0, 0, 0},{0, 0, 0, 0},};int height = arr2d.length;int width = arr2d[0].length;
iabbr <buffer> jarr_array2d int[][] arr = {{1, 2, 3, 4},{1, 2, 3, 4},{1, 2, 3, 4},{1, 2, 3, 4},};int height = arr2d.length;int width = arr2d[0].length;
iabbr <buffer> jarr_Integer Integer[] arr = {1, 2, 3, 4};
iabbr <buffer> jarr_char char[] arr = {'c', 'a', 't', 's'};
iabbr <buffer> jarr_array1d int[] arr = {1, 2, 3, 4};
iabbr <buffer> jarr_String String[] arr = {"techie", "dangling", "cat", "scene", "ancestor", "scene", "descend", "descended", "sibling", "dangling"};
iabbr <buffer> jmain_main_method import java.util.*;import java.io.*;import classfile.*;public class Solution{public static void main(String[] args) {}static void test0(){Aron.beg();Aron.end();}}
iabbr <buffer> jtime_LocalDateTime //import java.time.LocalDateTime;LocalDateTime time = LocalDateTime.parse("2007-12-03T10:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME);int year = time.getDayOfYear();Month month = time.getMonth();int  day = time.getDayOfMonth();int minute = time.getMinute();int second = time.getSecond();// create different datetime formatDateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");LocalDateTime time1 = LocalDateTime.parse("30/09/1970-18:34:13", format);
iabbr <buffer> screeninfo -(void)checkDevice{CGSize size = [[UIScreen mainScreen] bounds].size;CGFloat width = size.width;CGFloat height= size.height;CGFloat scale = [UIScreen mainScreen].scale;_screenWidth = width;_screenHeight = height;CGSize nativeSize = [[UIScreen mainScreen] nativeBounds].size;NSLog(@"width=[%f]", size.width);NSLog(@"height=[%f]", size.height);NSLog(@"scale =[%f]", scale);NSLog(@"nativeWidth=[%f]", nativeSize.width);NSLog(@"nativeHeight=[%f]", nativeSize.height);NSLog(@"scale =[%f]", scale);if([[UIDevice currentDevice] userInterfaceIdiom ] == UIUserInterfaceIdiomPhone){NSLog(@"iPhone");}else if([[UIDevice currentDevice] userInterfaceIdiom ] == UIUserInterfaceIdiomPad){NSLog(@"iPad");}else{NSLog(@"ERROR: Unsupported Device");}}--------------------------------------------------------------------iPhone 4swidth=[320.000000]height=[480.000000]scale =[2.000000]nativeWidth=[640.000000]nativeHeight=[960.000000]scale =[2.000000]--------------------------------------------------------------------iPhone 5 and upwidth=[320.000000]height=[568.000000]scale =[2.000000]nativeWidth=[640.000000]nativeHeight=[1136.000000]scale =[2.000000]--------------------------------------------------------------------iPad 2Switch Backwidth=[768.000000]height=[1024.000000]scale =[1.000000]nativeWidth=[768.000000]nativeHeight=[1024.000000]scale =[1.000000]iPad--------------------------------iPad Airwidth=[768.000000]height=[1024.000000]scale =[2.000000]nativeWidth=[1536.000000]nativeHeight=[2048.000000]scale =[2.000000]--------------------------------ipad Air 2Switch Backwidth=[768.000000]height=[1024.000000]scale =[2.000000]nativeWidth=[1536.000000]nativeHeight=[2048.000000]scale =[2.000000]--------------------------------
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal backupcopy=
setlocal nobinary
setlocal nobreakindent
setlocal breakindentopt=
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal nocindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=/*%s*/
setlocal complete=.,w,b,u,t,i,k/Users/cat/myfile/github/java/*,k/Users/cat/myfile/github/JavaLib/*,k/Users/cat/myfile/github/Jsource/*
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=CompleteAbbre
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=
setlocal expandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
set foldexpr=getline(v:lnum)[0]==\"^s*//\"
setlocal foldexpr=getline(v:lnum)[0]==\"^s*//\"
setlocal foldignore=#
setlocal foldlevel=0
set foldmarker=/**,*/
setlocal foldmarker=/**,*/
set foldmethod=expr
setlocal foldmethod=expr
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=tcq
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=
setlocal includeexpr=
setlocal indentexpr=
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal lispwords=
setlocal nolist
setlocal makeprg=
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
setlocal nonumber
setlocal numberwidth=4
setlocal omnifunc=csscomplete#CompleteCSS
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=0
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=~/myfile/github/vim/myword.utf-8.add
setlocal spelllang=en
setlocal statusline=
setlocal suffixesadd=
setlocal noswapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal undofile
setlocal undolevels=-123456
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
let s:l = 205 - ((27 * winheight(0) + 23) / 46)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
205
normal! 023|
lcd ~/myfile/github/java/CraiglistProject/src/com/company
tabnext 1
if exists('s:wipebuf')
  silent exe 'bwipe ' . s:wipebuf
endif
unlet! s:wipebuf
set winheight=1 winwidth=20 shortmess=filnxtToO
let s:sx = expand("<sfile>:p:r")."x.vim"
if file_readable(s:sx)
  exe "source " . fnameescape(s:sx)
endif
let &so = s:so_save | let &siso = s:siso_save
doautoall SessionLoadPost
unlet SessionLoad
" vim: set ft=vim :
