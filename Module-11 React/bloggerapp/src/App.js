import './App.css';
import BlogDetails from './components/BlogDetails';
import BookDetails from './components/BookDetails';
import CourseDetails from './components/CourseDetails';

function App() {

  const courses = [
    {id:1, cname:"Angular", date:"4/5/2021"},
    {id:2, cname:"React", date:"6/3/2021"},
  ]

  const books = [
        {id:101, bname:'Master React', price:670},
        {id:102, bname:'Deep Dive into Angular 11', price:800},
        {id:103, bname:'Mongo Essentials', price:450},
  ]

  const blogs = [
    {id:10, dname:"React Learning", author:"Stephen Biz", description:"Welcome to learning React!"},
    {id:10, dname:"Installation", author:"Schewzdenier", description:"You can install React from npm."},
  ]


  return (
    <div className="App">
      <div className='components'>
        <div className="column col">
            <h1>Course Details</h1>
            <CourseDetails courses={courses}/>
        </div>

        <div className="column col">
            <h1>Book Details</h1>
            <BookDetails books={books} />
        </div>

        <div className="column">
            <h1>Blog Details</h1>
            <BlogDetails blogs={blogs} />
        </div>
      </div>
    </div>
  );
}

export default App;
