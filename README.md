# snake-and-ladder

Firstly watch the image carefully

  Inorder to win the game we need to reach the 36 from 0 
  
    Here why starting from zero beacause when we play SNAKE AND LADDER we will be making our marker outside the Board 
    so that when we throw 1 we are placing our marker at 1.
    
    Note : In reality when we get a 6. we get another chance(But here we donot get a chance).
    
    Starting Game:
    
                    Making marker at 0th Node 
                    we are assuming board as a graph and also there is no cost between the edges.
                    So therfore we can go for BreadthFirstSearch.
                    
                    0th(NODE)-----when we throw 1------we goto Node board[(0+1)] 
                    
                    If we have ladder at that point we are going to that Ladder
                    
                   
                    
                   If I am at 0thNode and if I throws 2 then my Final Position will be 0(InitialPositionOftheMarker)+2(Thrown Number)+board[0+2];
                   here Board[Number] represents how many steps you need to go forward;
                    board[2] = 13;
                    board[5] = 2;
		                board[9] = 18;
		                board[25] = 10;(In the picture we have 4 ladders)
                    
                    (In the picture we have 5 snakes)
                    Where Board[Number] represents how many steps you need to go backward;
                    board[17] = -13;
		                board[20] = -14;
		                board[24] = -8;
		                board[32] = -2;
		                board[34] = -22;
                    
                    
		At last we will be printing shortest path from source(0) to destination(36) from given picture
       and also path that we follows.
       
       These Algorithm not only work for the given image you can make your own board and place board[Number] cost and you will be getting 
       shortest path from source(0) to destination(36) from given picture  and also path that we follows.
       
    
