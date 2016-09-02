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
" vim: set ft=vim :
