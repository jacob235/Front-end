package service;

import java.util.List;

import dao.BookDao;
import vo.BookVO;

public class BookServiceImpl implements BookService{
	BookDao dao;
	
	public BookServiceImpl() {}
	public BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}
	
	public BookDao getBookdao() {
		return dao;
	}
	public void setBookdao(BookDao dao) {
		this.dao = dao;
	}
	@Override
	public List<BookVO> bookList() {
		return dao.getAllBookRec();
	}

	@Override
	public int addBook(BookVO vo) throws Exception{
		return dao.insertBook(vo);
	}

	@Override
	public int deleteBook(int bookid) {
		return dao.deleteBook(bookid);
	}

	@Override
	public int updateBook(BookVO vo) {
		return dao.updateBook(vo);
	}
	@Override
	public List<BookVO> selectBook(String bookname) {
		return dao.selectBookName(bookname);
	}
	
}
