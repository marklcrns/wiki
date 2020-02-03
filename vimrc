if dein#tap('vimwiki')
	nnoremap <silent> <Leader>vw :<C-u>VimwikiIndex<CR>
endif

- repo: vimwiki/vimwiki
  on_map: { n: <Plug> }
  on_cmd: [ VimwikiIndex, VimwikiUISelect ]
  hook_add: |
    let g:vimwiki_use_calendar = 1
    let g:vimwiki_hl_headers = 1
    let g:vimwiki_hl_cb_checked = 1
    let g:vimwiki_autowriteall = 0
  hook_source: |
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
