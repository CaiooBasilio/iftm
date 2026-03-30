window.addEventListener("DOMContentLoaded", ()=>{
    const movies = {
        method: 'GET',
        headers: {
            accept: 'application/json',
            Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxM2Y1ZmIyNjg0ZWE1NDMxYjFjZThjMTcxNDY3MDMyZiIsIm5iZiI6MTc3NDYyNjI1OC4xNjgsInN1YiI6IjY5YzZhNWQyYWQ5OTYwMWIzY2FmZDU3NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XLIB8JVUizSJy5ur3s8cWiOpibjFRVQ-tqmumkSHGjw'
        }
    };

    const genre = {
        method: 'GET', 
        headers: {
            accept: 'application/json',
            Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxM2Y1ZmIyNjg0ZWE1NDMxYjFjZThjMTcxNDY3MDMyZiIsIm5iZiI6MTc3NDYyNjI1OC4xNjgsInN1YiI6IjY5YzZhNWQyYWQ5OTYwMWIzY2FmZDU3NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XLIB8JVUizSJy5ur3s8cWiOpibjFRVQ-tqmumkSHGjw'
        }
    };

    const imgsUrl = "https://image.tmdb.org/t/p/w500"

    const getMovie = async()=> {
        //chamo a url que ele vai pegar os filmes
        const urlMovies="https://api.themoviedb.org/3/movie/popular?language=pt-BR&page=1";
            
        // faço uma requisição, meio que pra descobrir se consegui pegar os filmes ou não
        try{
            const resp = await fetch(urlMovies, movies);
            if(!resp.ok)
                throw new Error("Erro excepcion")
            const filmes = await resp.json();

            return filmes.results
        }catch(error){
            console.log(error.message)
        }
    }

    const getGenre = async()=> {
        //chamo a url que ele vai pegar os filmes
        const urlGenre="https://api.themoviedb.org/3/genre/movie/list?language=pt-BR";
            
        // faço uma requisição, meio que pra descobrir se consegui pegar os filmes ou não
        try{
            const resp = await fetch(urlGenre, genre);
            if(!resp.ok)
                throw new Error("Erro excepcion")
            const generos = await resp.json();

            return generos
        }catch(error){
            console.log(error.message)
        }
    }

    var controle =0;

    const mostraFilmes = async() =>{
        const filmes = await getMovie();
        const generos = await getGenre();
        console.log(generos);

        filmes.slice(0,10).forEach(filme => {
            const genero = mostraGeneroFilme(filme.genre_ids, generos)

            var img = document.createElement("img");
            img.src=`${imgsUrl}${filme.poster_path}`
            document.getElementById(`filme${controle}`).appendChild(img);
            
            var h3 = document.createElement("h3");
            h3.className = "tituloFilme"
            h3.textContent = filme.title;
            document.getElementById(`filme${controle}`).appendChild(h3);

            var tipoDoFilme = document.createElement("p");
            tipoDoFilme.className = "Genero"
            tipoDoFilme.textContent = genero
            document.getElementById(`filme${controle}`).appendChild(tipoDoFilme)

            var descricao = document.createElement("p");
            descricao.className = "descricao"
            descricao.textContent = filme.overview;
            document.getElementById(`filme${controle}`).appendChild(descricao);

            var nota = document.createElement("p");
            nota.className = "notaFilme"
            var num = filme.vote_average;
            nota.textContent = `${num.toFixed(1)}/10`;
            document.getElementById(`filme${controle}`).appendChild(nota);
            
            controle++;
        });
    }

    const mostraGeneroFilme = (id, generoClass) =>{
        var nomeGenero = "";
        //fazendo 2 for, ja que os filmes possuem 2 ids
        for(let i=0; i<id.length; i++){
            for(let j=0; j<generoClass.genres.length; j++){
                if(i===id.length-1 && id[i] === generoClass.genres[j].id)
                    nomeGenero += generoClass.genres[j].name;
                else if(id[i] === generoClass.genres[j].id && id[i] != id.length -1)
                    nomeGenero += generoClass.genres[j].name + ", ";
            }
        }
        return nomeGenero;
    }


    // fetch('https://api.themoviedb.org/3/movie/popular?language=en-US&page=1', options)
    //     .then(res => res.json())
    //     .then(res => console.log(res))
    //     .catch(err => console.error(err));
    
    // const chamaMostraFilmes = async()=>{
    //     try{
    //         const respostaFilmes = await fetch(urlMovies, options);
    //         if(!respostaFilmes.ok)
    //             throw new Error("Errou")
    //         const filmes = await respostaFilmes.json();
    //         mostraFilme(filmes.results)
    //         console.log(filmes.results)
    //         // console.log(filmes.results[0].original_title)
    //         // console.log(filmes.results[0].poster_path)
    //     }catch(error){
    //         console.log(error.message)
    //     }
    // }


    // const mostraFilme = (filme) =>{
    //     for(let i=0; i<10; i++){
    //         var img = document.createElement("img");
    //         img.src= `https://image.tmdb.org/t/p/w200${filme[i].poster_path}`;
    //         document.getElementById(`filme${i}`).appendChild(img);
            
    //         var p = document.createElement("p");
    //         p.textContent = filme[i].title;
    //         document.getElementById(`filme${i}`).appendChild(p);
            
    //         var p2 = document.createElement("p");
    //         p2.textContent = filme[i].overview;
    //         document.getElementById(`filme${i}`).appendChild(p2);

    //         var p3 = document.createElement("p");
    //         var num = filme[i].vote_average;
    //         p3.textContent = `${num.toFixed(2)}/10`;
    //         document.getElementById(`filme${i}`).appendChild(p3);
    //     } 
        
    // }

    mostraFilmes();
})
