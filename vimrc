nnoremap <silent> <LocalLeader>vw :<C-u>VimwikiIndex<CR>

let g:vimwiki_use_calendar = 1
let g:vimwiki_hl_headers = 1
let g:vimwiki_hl_cb_checked = 1
let g:vimwiki_autowriteall = 0
let g:vimwiki_map_prefix = '<Leader>v'

let g:vimwiki_list = [
\   { 'diary_header': 'Diary',
\     'diary_link_fmt': '%Y-%m/%d',
\     'auto_toc': 1,
\     'path': '~/Docs/wiki/',
\     'syntax': 'markdown',
\     'ext': '.md' },
\   { 'path': '~/Docs/school/',
\     'syntax': 'markdown',
\     'ext': '.md' },
\   { 'path': '~/Docs/references/',
\     'syntax': 'markdown',
\     'ext': '.md' },
\ ]
